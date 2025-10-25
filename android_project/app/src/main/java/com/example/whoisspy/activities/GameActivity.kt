package com.example.whoisspy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whoisspy.R
import com.example.whoisspy.databinding.ActivityGameBinding
import com.example.whoisspy.adapters.PlayerAdapter
import com.example.whoisspy.adapters.SpeechAdapter
import com.example.whoisspy.managers.GameManager
import com.example.whoisspy.models.GameSettings
import com.example.whoisspy.models.Player

// 游戏常量类
object GameConstants {
    const val EXTRA_GAME_SETTINGS = "extra_game_settings"
}

class GameActivity : AppCompatActivity() {
    
    // UI组件引用
    private lateinit var binding: ActivityGameBinding
    
    // 游戏管理器
    private val gameManager: GameManager by lazy { GameManager.getInstance() }
    
    // 游戏设置
    private var gameSettings: GameSettings? = null
    
    // 游戏阶段相关变量
    private var currentPhase: GamePhase = GamePhase.PREPARATION
    private var currentSpeaker: Player? = null
    private var preparationPlayerIndex: Int = 0
    private var isWordVisible: Boolean = true
    
    // 适配器
    private lateinit var playerAdapter: PlayerAdapter
    private lateinit var speechAdapter: SpeechAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 使用视图绑定
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 初始化游戏
        initGame()
        
        // 设置按钮点击事件
        binding.buttonFinishViewing.setOnClickListener { finishViewing() }
        binding.buttonViewNext.setOnClickListener { viewNext() }
        binding.buttonStartSpeech.setOnClickListener { startSpeechPhase() }
        binding.buttonStartVote.setOnClickListener { startVotePhase() }
        binding.buttonNewGame.setOnClickListener { startNewGame() }
    }
    
    /**
     * 初始化游戏（简化版）
     */
    private fun initGame() {
        // 从Intent获取游戏设置
        gameSettings = intent.getParcelableExtra(GameConstants.EXTRA_GAME_SETTINGS)
        
        if (gameSettings == null) {
            Toast.makeText(this, "游戏设置无效", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        try {
            // 初始化游戏管理器
            gameManager.initializeGame(gameSettings!!)
            
            // 初始化UI
            initUI()
            
            // 开始游戏
            startGame()
        } catch (e: Exception) {
            Toast.makeText(this, "游戏初始化失败: ${e.message}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    
    /**
     * 初始化UI组件
     */
    private fun initUI() {
        playerAdapter = PlayerAdapter(gameManager.players) {}
        binding.recyclerViewPlayers.adapter = playerAdapter
        binding.recyclerViewPlayers.layoutManager = LinearLayoutManager(this)
        
        // 初始化发言记录列表
        speechAdapter = SpeechAdapter(emptyList())
        binding.recyclerViewSpeechRecord.adapter = speechAdapter
        binding.recyclerViewSpeechRecord.layoutManager = LinearLayoutManager(this)
    }

    /**
     * 开始游戏
     */
    private fun startGame() {
        updatePhaseIndicator()
    }

    /**
     * 完成查看
     */
    private fun finishViewing() {
        isWordVisible = false
        updatePhaseIndicator()
    }

    /**
     * 查看下一个
     */
    private fun viewNext() {
        preparationPlayerIndex++
        isWordVisible = true
        updatePhaseIndicator()
    }

    /**
     * 开始发言阶段（简化版）
     */
    private fun startSpeechPhase() {
        currentPhase = GamePhase.SPEECH
        updatePhaseIndicator()
        gameManager.startSpeech() // 通知GameManager开始发言阶段

        // 更新当前发言玩家
        currentSpeaker = gameManager.getCurrentSpeaker()
        updateCurrentSpeakerUI()
    }

    /**
     * 开始投票阶段（简化版）
     */
    private fun startVotePhase() {
        currentPhase = GamePhase.VOTE
        updatePhaseIndicator()
        gameManager.startVotePhase() // 通知GameManager开始投票阶段

        // 显示投票选项
        displayVoteOptions()
    }

    /**
     * 处理投票结果（简化版）
     */
    private fun processVoteResult() {
        val eliminatedPlayer = gameManager.processRoundResult()
        if (eliminatedPlayer != null) {
            showEliminationDialog(eliminatedPlayer)
        }

        if (gameManager.isGameOver()) {
            showGameResult()
        } else {
            // 如果游戏未结束，进入下一轮发言
            gameManager.nextRound()
            startSpeechPhase()
        }
    }

    /**
     * 显示投票选项（简化版）
     */
    private fun displayVoteOptions() {
        binding.linearLayoutVoteOptions.removeAllViews()
        val alivePlayers = gameManager.getAlivePlayers()

        alivePlayers.forEach { player ->
            val button = Button(this).apply {
                text = player.name
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                setOnClickListener {
                    // 简化投票逻辑，假设当前用户是第一个玩家
                    val voter = alivePlayers[0]
                    val voted = gameManager.submitVote(voter, player)
                    if (voted) {
                        Toast.makeText(this@GameActivity, "投票给 ${player.name}", Toast.LENGTH_SHORT).show()
                        // 简化：一人投票后直接处理结果
                        processVoteResult()
                    } else {
                        Toast.makeText(this@GameActivity, "投票失败，请重试", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            binding.linearLayoutVoteOptions.addView(button)
        }
    }

    /**
     * 更新阶段指示器
     */
    private fun updatePhaseIndicator() {
        when (currentPhase) {
            GamePhase.PREPARATION -> {
                binding.textViewGameStatus.text = "准备阶段"
                binding.recyclerViewSpeechRecord.visibility = View.GONE
                binding.textViewSpeechRecordTitle.visibility = View.GONE
                binding.recyclerViewPlayers.visibility = View.GONE
                binding.textViewPlayerListTitle.visibility = View.GONE
                if (isWordVisible) {
                    val currentPlayer = gameManager.players[preparationPlayerIndex]
                    binding.cardViewWord.visibility = View.VISIBLE
                    binding.textViewYourWord.text = "轮到【${currentPlayer.name}】查看身份"
                    binding.textViewWordValue.text = "你的词是：${currentPlayer.word ?: "无词"}"
                    binding.buttonFinishViewing.visibility = View.VISIBLE
                    binding.buttonViewNext.visibility = View.GONE
                    binding.buttonStartSpeech.visibility = View.GONE
                } else {
                    binding.cardViewWord.visibility = View.GONE
                    binding.buttonFinishViewing.visibility = View.GONE
                    if (preparationPlayerIndex < gameManager.players.size - 1) {
                        binding.buttonViewNext.visibility = View.VISIBLE
                        binding.buttonStartSpeech.visibility = View.GONE
                    } else {
                        binding.buttonViewNext.visibility = View.GONE
                        binding.buttonStartSpeech.visibility = View.VISIBLE
                    }
                }
            }
            GamePhase.SPEECH -> {
                binding.textViewGameStatus.text = "发言阶段"
                binding.recyclerViewSpeechRecord.visibility = View.GONE
                binding.textViewSpeechRecordTitle.visibility = View.GONE
                binding.recyclerViewPlayers.visibility = View.VISIBLE
                binding.textViewPlayerListTitle.visibility = View.VISIBLE
                binding.buttonStartSpeech.visibility = View.GONE
                binding.buttonStartVote.visibility = View.VISIBLE
                binding.linearLayoutVoteSection.visibility = View.GONE
                binding.cardViewWord.visibility = View.GONE // 隐藏词汇卡片
            }
            GamePhase.VOTE -> {
                binding.textViewGameStatus.text = "投票阶段"
                binding.recyclerViewSpeechRecord.visibility = View.GONE
                binding.textViewSpeechRecordTitle.visibility = View.GONE
                binding.recyclerViewPlayers.visibility = View.GONE
                binding.textViewPlayerListTitle.visibility = View.GONE
                binding.buttonStartSpeech.visibility = View.GONE
                binding.buttonStartVote.visibility = View.GONE
                binding.linearLayoutVoteSection.visibility = View.VISIBLE
                binding.cardViewWord.visibility = View.GONE // 隐藏词汇卡片
            }
        }
        
        // 更新当前回合信息
        binding.textViewCurrentTurn.text = "第${gameManager.currentRound}回合"
    }
    
    /**
     * 更新当前发言玩家UI
     */
    private fun updateCurrentSpeakerUI() {
        // 更新玩家列表
        playerAdapter.notifyDataSetChanged()
    }
    
    /**
     * 显示淘汰信息对话框
     */
    private fun showEliminationDialog(eliminatedPlayer: Player) {
        AlertDialog.Builder(this)
            .setTitle("玩家淘汰")
            .setMessage("${eliminatedPlayer.name} 被淘汰了！\n身份: ${eliminatedPlayer.getRoleName()}")
            .setPositiveButton("确定") { _, _ -> }
            .show()
        
        // 更新玩家列表
        playerAdapter.notifyDataSetChanged()
    }
    
    /**
     * 显示游戏结果（简化版）
     */
    private fun showGameResult() {
        binding.linearLayoutGameResult.visibility = View.VISIBLE
        binding.linearLayoutGameEndButtons.visibility = View.VISIBLE
        binding.buttonStartSpeech.visibility = View.GONE
        binding.buttonStartVote.visibility = View.GONE
        binding.cardViewWord.visibility = View.GONE // 游戏结束时隐藏词汇卡片
        
        val winnerRole = gameManager.getWinnerRole()
        binding.textViewWinner.text = "胜利者: $winnerRole"
        
        val allPlayersWords = StringBuilder()
        gameManager.players.forEach { player ->
            allPlayersWords.append("${player.name} (${player.getRoleName()}): ${player.word ?: "无词"}\n")
        }
        binding.textViewWordReveal.text = allPlayersWords.toString().trimEnd()
        
        // 标记游戏结束（简化版）
        gameManager.markGameOver()
    }
    
    private fun startNewGame() {
        val intent = Intent(this, GameSetupActivity::class.java)
        startActivity(intent)
        finish()
    }
    
    override fun onBackPressed() {
        // 防止误触返回键退出游戏
        Toast.makeText(this, "请使用游戏内按钮退出", Toast.LENGTH_SHORT).show()
    }
    
    /**
     * 游戏阶段枚举
     */
    enum class GamePhase {
        PREPARATION,
        SPEECH,
        VOTE
    }
}
