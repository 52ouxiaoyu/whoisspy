package com.example.whoisspy.managers

import android.content.Context
import com.example.whoisspy.models.Player
import com.example.whoisspy.models.GameSettings
import com.example.whoisspy.models.WordPair
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.nio.charset.StandardCharsets

/**
 * 游戏核心逻辑管理类 - 简化版
 */
class GameManager private constructor() {
    
    // 游戏状态
    var gameState: GameState = GameState.IDLE
    
    // 游戏设置
    lateinit var gameSettings: GameSettings
    
    // 玩家列表
    val players: MutableList<Player> = mutableListOf()
    
    // 当前词汇对
    var currentWordPair: WordPair? = null
    
    // 当前轮次
    var currentRound: Int = 1
    
    // 当前发言玩家索引
    var currentSpeakerIndex: Int = -1
    
    // 已投票玩家数量
    var votedPlayersCount: Int = 0
    
    // 游戏开始时间
    var gameStartTime: Long = 0
    
    // 词汇对列表
    private var wordPairs: List<WordPair> = emptyList()
    
    // 已使用的词汇对集合，用于跟踪已使用的词汇，确保使用到所有词汇
    private val usedWordPairs: MutableSet<WordPair> = mutableSetOf()
    
    /**
     * 从JSON文件加载词汇对的推荐方式说明：
     * 1. 对于开发阶段：可以使用上述绝对路径方式快速测试
     * 2. 对于正式应用：
     *    a. 将undercover_words.json放入assets文件夹
     *    b. 使用context.assets.open("undercover_words.json")读取
     *    c. 或者将词汇导入到Room数据库中使用
     * 3. 词汇使用策略：
     *    a. 按类别筛选词汇（如：只使用食物类词汇）
     *    b. 按难度筛选词汇
     *    c. 记录已使用词汇避免重复
     */
    private fun loadWordPairsFromJson() {
        try {
            // 方案1：从JSON文件直接加载（开发阶段使用）
            val jsonFile = File("/Users/wujun/python/谁是卧底/undercover_words.json")
            if (jsonFile.exists()) {
                val jsonString = jsonFile.readText(StandardCharsets.UTF_8)
                val jsonArray = JSONArray(jsonString)
                val pairs = mutableListOf<WordPair>()
                
                for (i in 0 until jsonArray.length()) {
                    val obj = jsonArray.getJSONObject(i)
                    pairs.add(WordPair(
                        civilianWord = obj.getString("normal_word"),
                        spyWord = obj.getString("undercover_word"),
                        category = obj.getString("category")
                    ))
                }
                
                wordPairs = pairs
            } else {
                // 方案2：直接使用解析后的词汇列表（推荐用于应用发布）
                // 这里直接使用解析后的结果，避免运行时文件IO操作
                wordPairs = listOf(
                    WordPair("饺子", "馄饨", "食物"),
                    WordPair("面包", "蛋糕", "食物"),
                    WordPair("苹果", "梨", "食物"),
                    WordPair("可乐", "雪碧", "饮品"),
                    WordPair("牛奶", "豆浆", "饮品"),
                    WordPair("篮球", "足球", "运动"),
                    WordPair("羽毛球", "网球", "运动"),
                    WordPair("猫", "老虎", "动物"),
                    WordPair("狗", "狼", "动物"),
                    WordPair("大象", "犀牛", "动物")
                )
            }
        } catch (e: Exception) {
            // 出错时使用备用词汇
            wordPairs = listOf(
                WordPair("电脑", "手机", "电子设备"),
                WordPair("苹果", "香蕉", "水果")
            )
        }
    }
    
    /**
     * 初始化游戏（使用JSON词汇）
     */
    fun initializeGame(settings: GameSettings) {
        this.gameSettings = settings
        this.gameState = GameState.PREPARING
        this.currentRound = 1
        this.currentSpeakerIndex = -1
        this.votedPlayersCount = 0
        this.players.clear()
        // 清空已使用词汇集合，开始新游戏时重新计数
        this.usedWordPairs.clear()
        
        // 加载词汇对
        loadWordPairsFromJson()
        
        // 生成玩家列表
        generatePlayers()
        
        // 选择未使用过的词汇对
        this.currentWordPair = selectUnusedWordPair()
        
        // 分配角色
        assignRoles()
        
        // 分配词汇
        assignWords()
        
        this.gameStartTime = System.currentTimeMillis()
    }
    
    /**
     * 选择未使用过的词汇对
     * 如果所有词汇都已使用，则重置已使用集合并重新开始
     */
    private fun selectUnusedWordPair(): WordPair {
        // 找出未使用的词汇对
        val unusedPairs = wordPairs.filter { it !in usedWordPairs }
        
        if (unusedPairs.isEmpty()) {
            // 如果所有词汇都已使用，重置已使用集合
            usedWordPairs.clear()
            // 返回任意一个词汇对并标记为已使用
            val newPair = wordPairs.random()
            usedWordPairs.add(newPair)
            return newPair
        } else {
            // 从剩余未使用的词汇对中随机选择
            val selectedPair = unusedPairs.random()
            usedWordPairs.add(selectedPair)
            return selectedPair
        }
    }
    
    /**
     * 获取当前玩家（用于GameActivity）
     */
    fun getCurrentPlayer(): Player {
        return players.firstOrNull() ?: throw IllegalStateException("No players available")
    }
    
    /**
     * 获取当前发言玩家（用于GameActivity）
     */
    fun getCurrentSpeakingPlayer(): Player {
        return getCurrentSpeaker() ?: throw IllegalStateException("No current speaker available. Speech phase may not have started or all players are eliminated.")
    }
    

    
    /**
     * 获取存活玩家（用于GameActivity）
     */
    fun getAlivePlayers(): List<Player> {
        return players.filter { it.isAlive }
    }
    
    /**
     * 提交投票（用于GameActivity）
     */
    fun submitVote(voter: Player, target: Player): Boolean {
        return vote(voter.id, target.id)
    }
    
    /**
     * 处理回合结果（用于GameActivity）
     */
    fun processRoundResult(): Player? {
        val eliminatedPlayer = endVote()
        
        if (eliminatedPlayer != null) {
            // 检查游戏是否结束
            if (checkGameEnd() != null) {
                gameState = GameState.GAME_OVER
            } else {
                // 进入下一轮，选择新的未使用词汇对
                nextRound()
                // 为新回合选择新的未使用词汇对
                this.currentWordPair = selectUnusedWordPair()
                // 重新分配词汇
                assignWords()
            }
        } else {
            // 如果没有玩家被淘汰，仍然需要检查游戏是否结束
            if (checkGameEnd() != null) {
                gameState = GameState.GAME_OVER
            } else {
                // 如果没有玩家被淘汰但游戏未结束，重新开始发言阶段
                startSpeechPhase()
            }
        }
        
        return eliminatedPlayer
    }
    
    /**
     * 游戏是否结束（用于GameActivity）
     */
    fun isGameOver(): Boolean {
        return gameState == GameState.GAME_OVER || checkGameEnd() != null
    }
    
    /**
     * 获取胜利者角色（用于GameActivity）
     */
    fun getWinnerRole(): String {
        return when (checkGameEnd()) {
            GameResult.CIVILIAN_WIN -> "平民"
            GameResult.SPY_WIN -> "卧底"
            GameResult.WHITEBOARD_WIN -> "白板"
            else -> "未知"
        }
    }
    
    /**
     * 获取平民词（用于GameActivity）
     */
    fun getCivilianWord(): String {
        return currentWordPair?.civilianWord ?: "未知"
    }
    
    /**
     * 获取卧底词（用于GameActivity）
     */
    fun getSpyWord(): String {
        return currentWordPair?.spyWord ?: "未知"
    }
    
    /**
     * 简化版：标记游戏结束
     */
    fun markGameOver() {
        gameState = GameState.GAME_OVER
    }
    
    /**
     * 生成玩家列表
     */
    private fun generatePlayers() {
        for (i in 0 until gameSettings.playerCount) {
            players.add(Player(
                id = i,
                name = "玩家${i + 1}"
            ))
        }
    }
    
    /**
     * 分配角色
     */
    private fun assignRoles() {
        val shuffledPlayers = players.shuffled().toMutableList()
        
        // 分配卧底
        for (i in 0 until gameSettings.spyCount) {
            shuffledPlayers[i].role = Player.Role.SPY
        }
        
        // 分配白板
        for (i in gameSettings.spyCount until gameSettings.spyCount + gameSettings.whiteboardCount) {
            shuffledPlayers[i].role = Player.Role.WHITEBOARD
        }
        
        // 剩下的都是平民
        for (i in gameSettings.spyCount + gameSettings.whiteboardCount until shuffledPlayers.size) {
            shuffledPlayers[i].role = Player.Role.CIVILIAN
        }
    }
    
    /**
     * 分配词汇
     */
    private fun assignWords() {
        players.forEach { player ->
            when (player.role) {
                Player.Role.CIVILIAN -> {
                    player.word = currentWordPair?.civilianWord
                }
                Player.Role.SPY -> {
                    player.word = currentWordPair?.spyWord
                }
                Player.Role.WHITEBOARD -> {
                    player.word = null
                }
            }
        }
    }
    
    /**
     * 开始发言（GameActivity调用的方法）
     */
    fun startSpeech() {
        startSpeechPhase()
    }
    
    /**
     * 开始发言阶段
     */
    fun startSpeechPhase() {
        gameState = GameState.SPEECH_PHASE
        currentSpeakerIndex = 0
        // 找到第一个存活的玩家
        findNextAlivePlayer()
    }
    
    /**
     * 获取当前发言玩家
     */
    fun getCurrentSpeaker(): Player? {
        return if (currentSpeakerIndex in players.indices && players[currentSpeakerIndex].isAlive) {
            players[currentSpeakerIndex]
        } else {
            null
        }
    }
    
    /**
     * 下一个发言玩家
     */
    fun nextSpeaker(): Boolean {
        currentSpeakerIndex = (currentSpeakerIndex + 1) % players.size
        return findNextAlivePlayer()
    }
    
    /**
     * 查找下一个存活的玩家
     */
    private fun findNextAlivePlayer(): Boolean {
        // 首先检查是否有存活玩家
        if (players.none { it.isAlive }) {
            return false
        }
        

        
        // 循环查找存活玩家，最多循环players.size次
        repeat(players.size) {
            if (players[currentSpeakerIndex].isAlive) {
                return true
            }
            currentSpeakerIndex = (currentSpeakerIndex + 1) % players.size
        }
        
        return false
    }
    
    /**
     * 开始投票阶段
     */
    fun startVotePhase() {
        gameState = GameState.VOTE_PHASE
        votedPlayersCount = 0
        players.forEach { it.resetVoteCount() }
    }
    
    /**
     * 玩家投票
     */
    fun vote(voterId: Int, targetId: Int): Boolean {
        val voter = players.find { it.id == voterId }
        val target = players.find { it.id == targetId }
        
        if (voter != null && target != null && voter.isAlive && target.isAlive) {
            target.voteCount++
            votedPlayersCount++
            return true
        }
        
        return false
    }
    
    /**
     * 结束投票，获取被淘汰的玩家
     */
    fun endVote(): Player? {
        val alivePlayers = players.filter { it.isAlive }
        if (alivePlayers.isEmpty()) return null
        
        // 找到得票最多的玩家
        val maxVotes = alivePlayers.maxOfOrNull { it.voteCount } ?: 0
        val candidates = alivePlayers.filter { it.voteCount == maxVotes }
        
        // 如果有多个玩家得票相同，选择第一个出现的
        val eliminatedPlayer = candidates.firstOrNull() ?: return null
        
        // 淘汰玩家
        eliminatedPlayer.isAlive = false
        
        // 更新游戏状态
        gameState = GameState.ELIMINATION_PHASE
        
        return eliminatedPlayer
    }
    
    /**
     * 检查游戏是否结束
     */
    fun checkGameEnd(): GameResult? {
        val aliveCivilians = players.count { it.role == Player.Role.CIVILIAN && it.isAlive }
        val aliveSpies = players.count { it.role == Player.Role.SPY && it.isAlive }
        val aliveWhiteboards = players.count { it.role == Player.Role.WHITEBOARD && it.isAlive }
        
        // 平民胜利条件：所有卧底被淘汰
        if (aliveSpies == 0) {
            return GameResult.CIVILIAN_WIN
        }
        
        // 卧底胜利条件：卧底数量等于或超过平民数量
        if (aliveSpies >= aliveCivilians) {
            return GameResult.SPY_WIN
        }
        
        // 白板胜利条件：只有白板存活
        if (aliveCivilians == 0 && aliveSpies == 0 && aliveWhiteboards > 0) {
            return GameResult.WHITEBOARD_WIN
        }
        
        return null
    }
    
    /**
     * 进入下一轮
     */
    fun nextRound() {
        currentRound++
        startSpeechPhase()
    }
    

    

    
    /**
     * 根据ID获取玩家
     */
    fun getPlayerById(id: Int): Player? {
        return players.find { it.id == id }
    }
    
    /**
     * 更新玩家名称
     */
    fun updatePlayerName(id: Int, newName: String) {
        players.find { it.id == id }?.name = newName
    }
    
    /**
     * 获取游戏时长（秒）
     */
    fun getGameDuration(): Int {
        return ((System.currentTimeMillis() - gameStartTime) / 1000).toInt()
    }
    
    /**
     * 游戏状态枚举
     */
    enum class GameState {
        IDLE,              // 空闲状态
        PREPARING,         // 准备中
        ROLE_ASSIGNMENT,   // 角色分配阶段
        SPEECH_PHASE,      // 发言阶段
        VOTE_PHASE,        // 投票阶段
        ELIMINATION_PHASE, // 淘汰阶段
        GAME_OVER          // 游戏结束
    }
    
    /**
     * 游戏结果枚举
     */
    enum class GameResult {
        CIVILIAN_WIN,      // 平民胜利
        SPY_WIN,           // 卧底胜利
        WHITEBOARD_WIN     // 白板胜利
    }
    
    companion object {
        @Volatile
        private var INSTANCE: GameManager? = null
        
        fun getInstance(): GameManager {
            return INSTANCE ?: synchronized(this) {
                val instance = GameManager()
                INSTANCE = instance
                instance
            }
        }
    }
}