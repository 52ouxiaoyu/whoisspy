package com.example.whoisspy.managers;

import android.content.Context;
import com.example.whoisspy.models.WordPair;
import com.example.whoisspy.repositories.WordRepository;
import kotlinx.coroutines.Dispatchers;

/**
 * 词库管理类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0011\u0010\u000b\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/whoisspy/managers/WordManager;", "", "()V", "isInitialized", "", "wordRepository", "Lcom/example/whoisspy/repositories/WordRepository;", "initialize", "", "context", "Landroid/content/Context;", "initializeDefaultWords", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class WordManager {
    private com.example.whoisspy.repositories.WordRepository wordRepository;
    private boolean isInitialized = false;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.whoisspy.managers.WordManager INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.managers.WordManager.Companion Companion = null;
    
    private WordManager() {
        super();
    }
    
    /**
     * 初始化词库管理器
     */
    public final void initialize(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    /**
     * 初始化默认词库
     */
    private final java.lang.Object initializeDefaultWords(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/whoisspy/managers/WordManager$Companion;", "", "()V", "INSTANCE", "Lcom/example/whoisspy/managers/WordManager;", "getInstance", "initialize", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void initialize(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.whoisspy.managers.WordManager getInstance() {
            return null;
        }
    }
}