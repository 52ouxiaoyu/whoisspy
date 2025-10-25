package com.example.whoisspy.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.whoisspy.database.AppDatabase
import com.example.whoisspy.database.GameHistoryDao
import com.example.whoisspy.models.GameHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 游戏历史仓库类
 */
class GameHistoryRepository(private val gameHistoryDao: GameHistoryDao) {
    
    // 获取所有游戏历史记录
    val allGameHistory: LiveData<List<GameHistory>> = gameHistoryDao.getAllGameHistory().asLiveData()
    
    /**
     * 获取最近的游戏历史记录
     */
    suspend fun getRecentGameHistory(limit: Int): List<GameHistory> {
        return withContext(Dispatchers.IO) {
            gameHistoryDao.getRecentGameHistory(limit)
        }
    }
    
    /**
     * 插入游戏历史记录
     */
    suspend fun insertGameHistory(gameHistory: GameHistory): Long {
        return withContext(Dispatchers.IO) {
            gameHistoryDao.insert(gameHistory)
        }
    }
    
    /**
     * 删除游戏历史记录
     */
    suspend fun deleteGameHistory(gameHistory: GameHistory) {
        withContext(Dispatchers.IO) {
            gameHistoryDao.delete(gameHistory)
        }
    }
    
    /**
     * 删除所有游戏历史记录
     */
    suspend fun deleteAllGameHistory() {
        withContext(Dispatchers.IO) {
            gameHistoryDao.deleteAll()
        }
    }
    
    /**
     * 根据ID删除游戏历史记录
     */
    suspend fun deleteGameHistoryById(id: Int) {
        withContext(Dispatchers.IO) {
            gameHistoryDao.deleteById(id)
        }
    }
    
    /**
     * 获取游戏统计数据
     */
    suspend fun getGameStatistics(): GameStatistics {
        return withContext(Dispatchers.IO) {
            val totalGames = gameHistoryDao.getTotalGames()
            val civilianWins = gameHistoryDao.getCivilianWins()
            val spyWins = gameHistoryDao.getSpyWins()
            GameStatistics(totalGames, civilianWins, spyWins)
        }
    }
    
    /**
     * 游戏统计数据类
     */
    data class GameStatistics(
        val totalGames: Int,
        val civilianWins: Int,
        val spyWins: Int
    ) {
        val whiteboardWins: Int
            get() = totalGames - civilianWins - spyWins
    }
    
    companion object {
        @Volatile
        private var INSTANCE: GameHistoryRepository? = null
        
        fun getInstance(context: Context): GameHistoryRepository {
            return INSTANCE ?: synchronized(this) {
                val database = AppDatabase.getDatabase(context)
                val instance = GameHistoryRepository(database.gameHistoryDao())
                INSTANCE = instance
                instance
            }
        }
    }
}