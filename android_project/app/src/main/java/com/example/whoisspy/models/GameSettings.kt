package com.example.whoisspy.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 游戏设置数据模型
 * @property playerCount 玩家数量
 * @property spyCount 卧底数量
 * @property whiteboardCount 白板数量
 * @property gameMode 游戏模式
 * @property wordCategory 词汇类别
 * @property speechTime 发言时间（秒）
 * @property voteTime 投票时间（秒）
 */
@Parcelize
data class GameSettings(
    var playerCount: Int = 6,
    var spyCount: Int = 1,
    var whiteboardCount: Int = 0,
    var gameMode: String = "经典模式",
    var wordCategory: String = "默认",
) : Parcelable {
    /**
     * 验证设置是否有效
     */
    fun isValid(): Boolean {
        return playerCount in 4..12 &&
               spyCount >= 1 &&
               whiteboardCount >= 0 &&
               (spyCount + whiteboardCount) < playerCount
    }
    
    /**
     * 获取平民数量
     */
    fun getCivilianCount(): Int {
        return playerCount - spyCount - whiteboardCount
    }
}