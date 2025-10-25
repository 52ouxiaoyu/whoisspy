package com.example.whoisspy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.whoisspy.R
import com.example.whoisspy.models.GameSettings

class GameSetupActivity : AppCompatActivity() {
    private lateinit var textViewPlayerCount: TextView
    private lateinit var buttonStartGame: Button
    private lateinit var buttonDecreasePlayers: Button
    private lateinit var buttonIncreasePlayers: Button
    private lateinit var textViewSpyCount: TextView
    private lateinit var buttonDecreaseSpies: Button
    private lateinit var buttonIncreaseSpies: Button
    private lateinit var textViewWhiteboardCount: TextView
    private lateinit var buttonDecreaseWhiteboards: Button
    private lateinit var buttonIncreaseWhiteboards: Button

    private var playerCount = 6
    private var spyCount = 1
    private var whiteboardCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_setup)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        textViewPlayerCount = findViewById(R.id.textViewPlayerCount)
        buttonStartGame = findViewById(R.id.buttonStartGame)
        buttonDecreasePlayers = findViewById(R.id.buttonDecreasePlayers)
        buttonIncreasePlayers = findViewById(R.id.buttonIncreasePlayers)
        textViewSpyCount = findViewById(R.id.textViewSpyCount)
        buttonDecreaseSpies = findViewById(R.id.buttonDecreaseSpies)
        buttonIncreaseSpies = findViewById(R.id.buttonIncreaseSpies)
        textViewWhiteboardCount = findViewById(R.id.textViewWhiteboardCount)
        buttonDecreaseWhiteboards = findViewById(R.id.buttonDecreaseWhiteboards)
        buttonIncreaseWhiteboards = findViewById(R.id.buttonIncreaseWhiteboards)

        updateUI()
    }

    private fun setupListeners() {
        buttonDecreasePlayers.setOnClickListener { updatePlayerCount(-1) }
        buttonIncreasePlayers.setOnClickListener { updatePlayerCount(1) }
        buttonDecreaseSpies.setOnClickListener { updateSpyCount(-1) }
        buttonIncreaseSpies.setOnClickListener { updateSpyCount(1) }
        buttonDecreaseWhiteboards.setOnClickListener { updateWhiteboardCount(-1) }
        buttonIncreaseWhiteboards.setOnClickListener { updateWhiteboardCount(1) }
        
        buttonStartGame.setOnClickListener { startGame() }
    }

    private fun updateUI() {
        textViewPlayerCount.text = playerCount.toString()
        textViewSpyCount.text = spyCount.toString()
        textViewWhiteboardCount.text = whiteboardCount.toString()

        buttonDecreasePlayers.isEnabled = playerCount > 4
        buttonIncreasePlayers.isEnabled = playerCount < 12
        buttonDecreaseSpies.isEnabled = spyCount > 1
        buttonIncreaseSpies.isEnabled = spyCount < 2
        buttonDecreaseWhiteboards.isEnabled = whiteboardCount > 0
        buttonIncreaseWhiteboards.isEnabled = whiteboardCount < 1
    }

    private fun updatePlayerCount(change: Int) {
        val newCount = playerCount + change
        if (newCount in 4..12) {
            playerCount = newCount
            updateUI()
        }
    }

    private fun updateSpyCount(change: Int) {
        val newCount = spyCount + change
        if (newCount in 1..2) {
            spyCount = newCount
            updateUI()
        }
    }

    private fun updateWhiteboardCount(change: Int) {
        val newCount = whiteboardCount + change
        if (newCount in 0..1) {
            whiteboardCount = newCount
            updateUI()
        }
    }

    private fun startGame() {
        val gameSettings = GameSettings(
            playerCount = playerCount,
            spyCount = spyCount,
            whiteboardCount = whiteboardCount,
            wordCategory = "默认",
            gameMode = "标准"
        )

        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra(GameConstants.EXTRA_GAME_SETTINGS, gameSettings)
        startActivity(intent)
        finish()
    }
}