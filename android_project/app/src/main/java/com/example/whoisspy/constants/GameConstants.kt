package com.example.whoisspy.constants

/**
 * 游戏常量类
 */
object GameConstants {
    // 游戏状态
    const val STATE_PREPARING = "preparing"
    const val STATE_SPEECH = "speech"
    const val STATE_VOTE = "vote"
    const val STATE_RESULT = "result"
    const val STATE_GAME_OVER = "game_over"

    // Intent 额外数据键
    const val EXTRA_GAME_SETTINGS = "game_settings"
    const val EXTRA_CURRENT_PLAYER = "current_player"
    const val EXTRA_PLAYER_INDEX = "player_index"

    // 游戏设置默认值
    const val DEFAULT_PLAYER_COUNT = 8
    const val DEFAULT_SPY_COUNT = 2
    const val DEFAULT_WHITEBOARD_COUNT = 0
    const val DEFAULT_SPEECH_TIME_LIMIT = 60 // 秒
    const val DEFAULT_VOTE_TIME_LIMIT = 30 // 秒

    // 游戏设置范围
    const val MIN_PLAYER_COUNT = 4
    const val MAX_PLAYER_COUNT = 16
    const val MIN_SPY_COUNT = 1
    const val MAX_SPY_COUNT = 4
    const val MIN_WHITEBOARD_COUNT = 0
    const val MAX_WHITEBOARD_COUNT = 2

    // 时间限制范围
    const val MIN_SPEECH_TIME = 10
    const val MAX_SPEECH_TIME = 120
    const val MIN_VOTE_TIME = 10
    const val MAX_VOTE_TIME = 60
}