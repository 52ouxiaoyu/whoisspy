package com.example.whoisspy.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.whoisspy.models.GameHistory
import kotlinx.coroutines.flow.Flow

/**
 * 游戏历史数据访问接口
 */
@Dao
interface GameHistoryDao {
    
    /**
     * 获取所有游戏历史记录
     */
    @Query("SELECT * FROM game_history ORDER BY gameTime DESC")
    fun getAllGameHistory(): Flow<List<GameHistory>>
    
    /**
     * 获取最近的游戏历史记录
     */
    @Query("SELECT * FROM game_history ORDER BY gameTime DESC LIMIT :limit")
    suspend fun getRecentGameHistory(limit: Int): List<GameHistory>
    
    /**
     * 插入游戏历史记录
     */
    @Insert
    suspend fun insert(gameHistory: GameHistory): Long
    
    /**
     * 删除游戏历史记录
     */
    @Delete
    suspend fun delete(gameHistory: GameHistory): Unit
    
    /**
     * 删除所有游戏历史记录
     */
    @Query("DELETE FROM game_history")
    suspend fun deleteAll(): Unit
    
    /**
     * 根据ID删除游戏历史记录
     */
    @Query("DELETE FROM game_history WHERE id = :id")
    suspend fun deleteById(id: Int): Int
    
    /**
     * 获取游戏统计数据
     */
    @Query("SELECT COUNT(*) FROM game_history")
    suspend fun getTotalGames(): Int
    
    /**
     * 获取平民胜利次数
     */
    @Query("SELECT COUNT(*) FROM game_history WHERE winnerRole = '平民' OR winnerRole = '平民胜利'")
    suspend fun getCivilianWins(): Int
    
    /**
     * 获取卧底胜利次数
     */
    @Query("SELECT COUNT(*) FROM game_history WHERE winnerRole = '卧底' OR winnerRole = '卧底胜利'")
    suspend fun getSpyWins(): Int
}