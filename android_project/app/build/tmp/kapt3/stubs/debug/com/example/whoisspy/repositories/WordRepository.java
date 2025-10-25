package com.example.whoisspy.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.whoisspy.database.AppDatabase;
import com.example.whoisspy.database.WordPairDao;
import com.example.whoisspy.models.WordPair;
import kotlinx.coroutines.Dispatchers;

/**
 * 词汇仓库类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001b\u001a\u00020\u0018J\u001f\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/example/whoisspy/repositories/WordRepository;", "", "wordPairDao", "Lcom/example/whoisspy/database/WordPairDao;", "(Lcom/example/whoisspy/database/WordPairDao;)V", "allWordPairs", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/whoisspy/models/WordPair;", "getAllWordPairs", "()Landroidx/lifecycle/LiveData;", "customWordPairs", "getCustomWordPairs", "defaultWordPairs", "getDefaultWordPairs", "deleteCustomWordPairById", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWordPair", "", "wordPair", "(Lcom/example/whoisspy/models/WordPair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomWordPair", "category", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWordPairsByCategory", "insertAllWordPairs", "wordPairs", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWordPair", "", "Companion", "app_debug"})
public final class WordRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.whoisspy.database.WordPairDao wordPairDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> allWordPairs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> customWordPairs = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> defaultWordPairs = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.whoisspy.repositories.WordRepository INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.repositories.WordRepository.Companion Companion = null;
    
    public WordRepository(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.database.WordPairDao wordPairDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> getAllWordPairs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> getCustomWordPairs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> getDefaultWordPairs() {
        return null;
    }
    
    /**
     * 根据类别获取词汇对
     */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.WordPair>> getWordPairsByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
        return null;
    }
    
    /**
     * 随机获取一个词汇对
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRandomWordPair(@org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.whoisspy.models.WordPair> $completion) {
        return null;
    }
    
    /**
     * 插入词汇对
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertWordPair(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.WordPair wordPair, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    /**
     * 批量插入词汇对
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertAllWordPairs(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.whoisspy.models.WordPair> wordPairs, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 删除词汇对
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteWordPair(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.WordPair wordPair, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 删除自定义词汇对
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteCustomWordPairById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    /**
     * 获取所有类别
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/whoisspy/repositories/WordRepository$Companion;", "", "()V", "INSTANCE", "Lcom/example/whoisspy/repositories/WordRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.whoisspy.repositories.WordRepository getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}