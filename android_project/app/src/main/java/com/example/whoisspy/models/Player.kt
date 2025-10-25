package com.example.whoisspy.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 玩家数据模型
 * @property id 玩家唯一标识符
 * @property name 玩家名称
 * @property role 玩家角色（平民、卧底、白板）
 * @property word 玩家获得的词汇（白板为null）
 * @property isAlive 是否存活
 * @property voteCount 获得的票数
 */
data class Player(
    val id: Int,
    var name: String,
    var role: Role = Role.CIVILIAN,
    var word: String? = null,
    var isAlive: Boolean = true,
    var voteCount: Int = 0
) {
    /**
     * 角色枚举
     */
    enum class Role {
        CIVILIAN, // 平民
        SPY,      // 卧底
        WHITEBOARD // 白板
    }
    
    /**
     * 重置投票数
     */
    fun resetVoteCount() {
        voteCount = 0
    }
    
    /**
     * 获取角色的中文名称
     */
    fun getRoleName(): String {
        return when (role) {
            Role.CIVILIAN -> "平民"
            Role.SPY -> "卧底"
            Role.WHITEBOARD -> "白板"
        }
    }
}