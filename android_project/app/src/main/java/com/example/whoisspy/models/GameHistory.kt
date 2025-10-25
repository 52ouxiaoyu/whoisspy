package com.example.whoisspy.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * 游戏历史记录数据模型
 * @property id 唯一标识符
 * @property gameTime 游戏时间
 * @property playerCount 玩家数量
 * @property spyCount 卧底数量
 * @property whiteboardCount 白板数量
 * @property civilianWord 平民词汇
 * @property spyWord 卧底词汇
 * @property winnerRole 胜利者角色
 * @property gameMode 游戏模式
 * @property duration 游戏时长（秒）
 */
@Entity(tableName = "game_history")
data class GameHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val gameTime: Date,
    val playerCount: Int,
    val spyCount: Int,
    val whiteboardCount: Int,
    val civilianWord: String,
    val spyWord: String,
    val winnerRole: String,
    val gameMode: String,
    val duration: Int
)