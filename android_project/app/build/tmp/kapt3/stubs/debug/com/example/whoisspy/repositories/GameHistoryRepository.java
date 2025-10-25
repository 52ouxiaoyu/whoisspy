package com.example.whoisspy.repositories;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.whoisspy.database.AppDatabase;
import com.example.whoisspy.database.GameHistoryDao;
import com.example.whoisspy.models.GameHistory;
import kotlinx.coroutines.Dispatchers;

/**
 * 游戏历史仓库类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0018\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/whoisspy/repositories/GameHistoryRepository;", "", "gameHistoryDao", "Lcom/example/whoisspy/database/GameHistoryDao;", "(Lcom/example/whoisspy/database/GameHistoryDao;)V", "allGameHistory", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/whoisspy/models/GameHistory;", "getAllGameHistory", "()Landroidx/lifecycle/LiveData;", "deleteAllGameHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGameHistory", "gameHistory", "(Lcom/example/whoisspy/models/GameHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGameHistoryById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameStatistics", "Lcom/example/whoisspy/repositories/GameHistoryRepository$GameStatistics;", "getRecentGameHistory", "limit", "insertGameHistory", "", "Companion", "GameStatistics", "app_debug"})
public final class GameHistoryRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.whoisspy.database.GameHistoryDao gameHistoryDao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.GameHistory>> allGameHistory = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.whoisspy.repositories.GameHistoryRepository INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.repositories.GameHistoryRepository.Companion Companion = null;
    
    public GameHistoryRepository(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.database.GameHistoryDao gameHistoryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.whoisspy.models.GameHistory>> getAllGameHistory() {
        return null;
    }
    
    /**
     * 获取最近的游戏历史记录
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecentGameHistory(int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.whoisspy.models.GameHistory>> $completion) {
        return null;
    }
    
    /**
     * 插入游戏历史记录
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertGameHistory(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.GameHistory gameHistory, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    /**
     * 删除游戏历史记录
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteGameHistory(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.GameHistory gameHistory, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 删除所有游戏历史记录
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAllGameHistory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 根据ID删除游戏历史记录
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteGameHistoryById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * 获取游戏统计数据
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getGameStatistics(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.whoisspy.repositories.GameHistoryRepository.GameStatistics> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/whoisspy/repositories/GameHistoryRepository$Companion;", "", "()V", "INSTANCE", "Lcom/example/whoisspy/repositories/GameHistoryRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.whoisspy.repositories.GameHistoryRepository getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
    
    /**
     * 游戏统计数据类
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/example/whoisspy/repositories/GameHistoryRepository$GameStatistics;", "", "totalGames", "", "civilianWins", "spyWins", "(III)V", "getCivilianWins", "()I", "getSpyWins", "getTotalGames", "whiteboardWins", "getWhiteboardWins", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class GameStatistics {
        private final int totalGames = 0;
        private final int civilianWins = 0;
        private final int spyWins = 0;
        
        public GameStatistics(int totalGames, int civilianWins, int spyWins) {
            super();
        }
        
        public final int getTotalGames() {
            return 0;
        }
        
        public final int getCivilianWins() {
            return 0;
        }
        
        public final int getSpyWins() {
            return 0;
        }
        
        public final int getWhiteboardWins() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.whoisspy.repositories.GameHistoryRepository.GameStatistics copy(int totalGames, int civilianWins, int spyWins) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}