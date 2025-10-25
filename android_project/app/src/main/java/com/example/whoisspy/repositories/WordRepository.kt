package com.example.whoisspy.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.whoisspy.database.AppDatabase
import com.example.whoisspy.database.WordPairDao
import com.example.whoisspy.models.WordPair
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 词汇仓库类
 */
class WordRepository(private val wordPairDao: WordPairDao) {
    
    // 获取所有词汇对
    val allWordPairs: LiveData<List<WordPair>> = wordPairDao.getAllWordPairs().asLiveData()
    
    // 获取自定义词汇对
    val customWordPairs: LiveData<List<WordPair>> = wordPairDao.getCustomWordPairs().asLiveData()
    
    // 获取默认词汇对
    val defaultWordPairs: LiveData<List<WordPair>> = wordPairDao.getDefaultWordPairs().asLiveData()
    
    /**
     * 根据类别获取词汇对
     */
    fun getWordPairsByCategory(category: String): LiveData<List<WordPair>> {
        return wordPairDao.getWordPairsByCategory(category).asLiveData()
    }
    
    /**
     * 随机获取一个词汇对
     */
    suspend fun getRandomWordPair(category: String): WordPair? {
        return withContext(Dispatchers.IO) {
            wordPairDao.getRandomWordPair(category)
        }
    }
    
    /**
     * 插入词汇对
     */
    suspend fun insertWordPair(wordPair: WordPair): Long {
        return withContext(Dispatchers.IO) {
            wordPairDao.insert(wordPair)
        }
    }
    
    /**
     * 批量插入词汇对
     */
    suspend fun insertAllWordPairs(wordPairs: List<WordPair>) {
        withContext(Dispatchers.IO) {
            wordPairDao.insertAll(wordPairs)
        }
    }
    
    /**
     * 删除词汇对
     */
    suspend fun deleteWordPair(wordPair: WordPair) {
        withContext(Dispatchers.IO) {
            wordPairDao.delete(wordPair)
        }
    }
    
    /**
     * 删除自定义词汇对
     */
    suspend fun deleteCustomWordPairById(id: Int): Int {
        return withContext(Dispatchers.IO) {
            wordPairDao.deleteCustomWordPairById(id)
        }
    }
    
    /**
     * 获取所有类别
     */
    suspend fun getAllCategories(): List<String> {
        return withContext(Dispatchers.IO) {
            wordPairDao.getAllCategories()
        }
    }
    
    companion object {
        @Volatile
        private var INSTANCE: WordRepository? = null
        
        fun getInstance(context: Context): WordRepository {
            return INSTANCE ?: synchronized(this) {
                val database = AppDatabase.getDatabase(context)
                val instance = WordRepository(database.wordPairDao())
                INSTANCE = instance
                instance
            }
        }
    }
}