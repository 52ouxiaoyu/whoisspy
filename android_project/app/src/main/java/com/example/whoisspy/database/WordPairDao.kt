package com.example.whoisspy.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whoisspy.models.WordPair
import kotlinx.coroutines.flow.Flow

/**
 * 词汇对数据访问接口
 */
@Dao
interface WordPairDao {
    
    /**
     * 获取所有词汇对
     */
    @Query("SELECT * FROM word_pairs ORDER BY createTime DESC")
    fun getAllWordPairs(): Flow<List<WordPair>>
    
    /**
     * 根据类别获取词汇对
     */
    @Query("SELECT * FROM word_pairs WHERE category = :category ORDER BY createTime DESC")
    fun getWordPairsByCategory(category: String): Flow<List<WordPair>>
    
    /**
     * 获取自定义词汇对
     */
    @Query("SELECT * FROM word_pairs WHERE isCustom = 1 ORDER BY createTime DESC")
    fun getCustomWordPairs(): Flow<List<WordPair>>
    
    /**
     * 获取非自定义词汇对
     */
    @Query("SELECT * FROM word_pairs WHERE isCustom = 0 ORDER BY createTime DESC")
    fun getDefaultWordPairs(): Flow<List<WordPair>>
    
    /**
     * 随机获取一个词汇对
     */
    @Query("SELECT * FROM word_pairs WHERE category = :category OR category = '默认' ORDER BY RANDOM() LIMIT 1")
    fun getRandomWordPair(category: String): WordPair?
    
    /**
     * 插入词汇对
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(wordPair: WordPair): Long
    
    /**
     * 批量插入词汇对
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(wordPairs: List<WordPair>)
    
    /**
     * 删除词汇对
     */
    @Delete
    fun delete(wordPair: WordPair)
    
    /**
     * 根据ID删除词汇对
     */
    @Query("DELETE FROM word_pairs WHERE id = :id AND isCustom = 1")
    fun deleteCustomWordPairById(id: Int): Int
    
    /**
     * 获取所有类别
     */
    @Query("SELECT DISTINCT category FROM word_pairs ORDER BY category")
    fun getAllCategories(): List<String>
}