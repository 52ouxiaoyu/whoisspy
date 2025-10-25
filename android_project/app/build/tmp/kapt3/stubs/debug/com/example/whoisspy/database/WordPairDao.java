package com.example.whoisspy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.whoisspy.models.WordPair;
import kotlinx.coroutines.flow.Flow;

/**
 * 词汇对数据访问接口
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\rH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\rH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\rH\'J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\r2\u0006\u0010\u0011\u001a\u00020\u000bH\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2 = {"Lcom/example/whoisspy/database/WordPairDao;", "", "delete", "", "wordPair", "Lcom/example/whoisspy/models/WordPair;", "deleteCustomWordPairById", "", "id", "getAllCategories", "", "", "getAllWordPairs", "Lkotlinx/coroutines/flow/Flow;", "getCustomWordPairs", "getDefaultWordPairs", "getRandomWordPair", "category", "getWordPairsByCategory", "insert", "", "insertAll", "wordPairs", "app_debug"})
@androidx.room.Dao
public abstract interface WordPairDao {
    
    /**
     * 获取所有词汇对
     */
    @androidx.room.Query(value = "SELECT * FROM word_pairs ORDER BY createTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.whoisspy.models.WordPair>> getAllWordPairs();
    
    /**
     * 根据类别获取词汇对
     */
    @androidx.room.Query(value = "SELECT * FROM word_pairs WHERE category = :category ORDER BY createTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.whoisspy.models.WordPair>> getWordPairsByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    /**
     * 获取自定义词汇对
     */
    @androidx.room.Query(value = "SELECT * FROM word_pairs WHERE isCustom = 1 ORDER BY createTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.whoisspy.models.WordPair>> getCustomWordPairs();
    
    /**
     * 获取非自定义词汇对
     */
    @androidx.room.Query(value = "SELECT * FROM word_pairs WHERE isCustom = 0 ORDER BY createTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.whoisspy.models.WordPair>> getDefaultWordPairs();
    
    /**
     * 随机获取一个词汇对
     */
    @androidx.room.Query(value = "SELECT * FROM word_pairs WHERE category = :category OR category = \'\u9ed8\u8ba4\' ORDER BY RANDOM() LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract com.example.whoisspy.models.WordPair getRandomWordPair(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    /**
     * 插入词汇对
     */
    @androidx.room.Insert(onConflict = 1)
    public abstract long insert(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.WordPair wordPair);
    
    /**
     * 批量插入词汇对
     */
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.whoisspy.models.WordPair> wordPairs);
    
    /**
     * 删除词汇对
     */
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.WordPair wordPair);
    
    /**
     * 根据ID删除词汇对
     */
    @androidx.room.Query(value = "DELETE FROM word_pairs WHERE id = :id AND isCustom = 1")
    public abstract int deleteCustomWordPairById(int id);
    
    /**
     * 获取所有类别
     */
    @androidx.room.Query(value = "SELECT DISTINCT category FROM word_pairs ORDER BY category")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<java.lang.String> getAllCategories();
}