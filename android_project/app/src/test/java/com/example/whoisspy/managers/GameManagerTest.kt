package com.example.whoisspy.managers

import com.example.whoisspy.models.GameSettings
import com.example.whoisspy.models.Player
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class GameManagerTest {
    private lateinit var gameManager: GameManager
    private lateinit var settings: GameSettings

    @Before
    fun setUp() {
        // 重置单例实例（通过反射）
        resetInstance()
        
        // 获取GameManager实例
        gameManager = GameManager.getInstance()
        
        // 创建测试设置
        settings = GameSettings(
            playerCount = 6,
            spyCount = 1,
            whiteboardCount = 1,
            wordCategory = "默认",
            speechTime = 60,
            voteTime = 30
        )
    }

    @After
    fun tearDown() {
        // 清理测试数据
    }

    // 重置GameManager单例（通过反射）
    private fun resetInstance() {
        try {
            val field = GameManager::class.java.getDeclaredField("INSTANCE")
            field.isAccessible = true
            field.set(null, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test
    fun initializeGame_shouldSetUpGameCorrectly() = runBlocking {
        gameManager.initializeGame(settings)

        // 验证初始化结果
        assertEquals(GameManager.GameState.PREPARING, gameManager.gameState)
        assertEquals(1, gameManager.currentRound)
        assertEquals(6, gameManager.players.size)
        
        // 验证角色分配正确
        val spyCount = gameManager.players.count { it.role == Player.Role.SPY }
        val whiteboardCount = gameManager.players.count { it.role == Player.Role.WHITEBOARD }
        val civilianCount = gameManager.players.count { it.role == Player.Role.CIVILIAN }
        
        assertEquals(1, spyCount)
        assertEquals(1, whiteboardCount)
        assertEquals(4, civilianCount)
    }

    @Test
    fun startSpeechPhase_shouldSetCorrectStateAndSpeaker() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }

        // 执行测试
        gameManager.startSpeechPhase()

        // 验证结果
        assertEquals(GameManager.GameState.SPEECH_PHASE, gameManager.gameState)
        assertNotNull(gameManager.getCurrentSpeaker())
        assertTrue(gameManager.getCurrentSpeaker()?.isAlive ?: false)
    }

    @Test
    fun nextSpeaker_shouldMoveToNextAlivePlayer() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        gameManager.startSpeechPhase()
        
        val firstSpeaker = gameManager.getCurrentSpeaker()
        
        // 执行测试
        val hasNext = gameManager.nextSpeaker()
        val secondSpeaker = gameManager.getCurrentSpeaker()

        // 验证结果
        assertTrue(hasNext)
        assertNotSame(firstSpeaker, secondSpeaker)
        assertTrue(secondSpeaker?.isAlive ?: false)
    }

    @Test
    fun vote_shouldIncreaseTargetVoteCount() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        val voter = gameManager.players[0]
        val target = gameManager.players[1]
        val initialVoteCount = target.voteCount

        // 执行测试
        val result = gameManager.vote(voter.id, target.id)

        // 验证结果
        assertTrue(result)
        assertEquals(initialVoteCount + 1, target.voteCount)
        assertEquals(1, gameManager.votedPlayersCount)
    }

    @Test
    fun vote_shouldReturnFalseForInvalidVotes() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        val voter = gameManager.players[0]
        
        // 测试无效的目标ID
        val invalidResult = gameManager.vote(voter.id, 999)
        assertFalse(invalidResult)
        assertEquals(0, gameManager.votedPlayersCount)
        
        // 测试淘汰玩家后投票
        voter.isAlive = false
        val deadVoterResult = gameManager.vote(voter.id, gameManager.players[1].id)
        assertFalse(deadVoterResult)
    }

    @Test
    fun endVote_shouldEliminatePlayerWithMostVotes() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        val target = gameManager.players[0]
        val otherPlayer = gameManager.players[1]
        
        // 给目标玩家投票
        gameManager.vote(gameManager.players[1].id, target.id)
        gameManager.vote(gameManager.players[2].id, target.id)
        gameManager.vote(gameManager.players[3].id, otherPlayer.id)

        // 执行测试
        val eliminatedPlayer = gameManager.endVote()

        // 验证结果
        assertEquals(target, eliminatedPlayer)
        assertFalse(eliminatedPlayer?.isAlive ?: true)
        assertEquals(GameManager.GameState.ELIMINATION_PHASE, gameManager.gameState)
    }

    @Test
    fun checkGameEnd_civilianWinCondition() {
        // 准备游戏 - 平民胜利场景
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        // 淘汰所有卧底
        gameManager.players.forEach { player ->
            if (player.role == Player.Role.SPY) {
                player.isAlive = false
            }
        }

        // 执行测试
        val result = gameManager.checkGameEnd()

        // 验证结果
        assertEquals(GameManager.GameResult.CIVILIAN_WIN, result)
    }

    @Test
    fun checkGameEnd_spyWinCondition() {
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        // 淘汰足够的平民，使卧底数量等于或超过平民数量
        var civilianCount = 0
        gameManager.players.forEach { player ->
            if (player.role == Player.Role.CIVILIAN && civilianCount < 3) {
                player.isAlive = false
                civilianCount++
            }
        }

        // 执行测试
        val result = gameManager.checkGameEnd()

        // 验证结果
        assertEquals(GameManager.GameResult.SPY_WIN, result)
    }

    @Test
    fun getCurrentSpeakingPlayer_shouldReturnCurrentSpeaker() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        gameManager.startSpeechPhase()
        
        val speaker = gameManager.getCurrentSpeaker()
        
        // 执行测试
        val result = gameManager.getCurrentSpeakingPlayer()
        
        // 验证结果
        assertEquals(speaker, result)
    }

    @Test(expected = IllegalStateException::class)
    fun getCurrentSpeakingPlayer_shouldThrowExceptionWhenNoSpeaker() {
        // 准备没有发言玩家的情况
        gameManager.currentSpeakerIndex = -1
        
        // 执行测试 - 应该抛出异常
        gameManager.getCurrentSpeakingPlayer()
    }

    @Test
    fun getAlivePlayers_shouldReturnOnlyAlivePlayers() {
        // 准备游戏
        runBlocking {
            gameManager.initializeGame(settings)
        }
        
        // 设置一些玩家为死亡
        gameManager.players[0].isAlive = false
        gameManager.players[1].isAlive = false
        
        // 执行测试
        val alivePlayers = gameManager.getAlivePlayers()
        
        // 验证结果
        assertEquals(4, alivePlayers.size)
        assertTrue(alivePlayers.all { it.isAlive })
    }

    @Test
    fun processRoundResult_shouldHandleEliminationAndCheckGameEnd() {
        // 准备游戏 - 简化版调用
        gameManager.initializeGame(settings)
        
        // 开始投票阶段并投票
        gameManager.startVotePhase()
        val target = gameManager.players.first { it.role == Player.Role.SPY }
        gameManager.vote(gameManager.players[0].id, target.id)
        gameManager.vote(gameManager.players[1].id, target.id)
        
        // 执行测试
        val eliminatedPlayer = gameManager.processRoundResult()
        
        // 验证结果
        assertEquals(target, eliminatedPlayer)
        assertFalse(eliminatedPlayer?.isAlive ?: true)
        // 由于淘汰了唯一的卧底，游戏应该结束
        assertTrue(gameManager.isGameOver())
    }
}