package com.example.whoisspy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.whoisspy.models.GameHistory;
import kotlinx.coroutines.flow.Flow;

/**
 * 游戏历史数据访问接口
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000eH\'J\u0011\u0010\u0010\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u0013\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\u0014\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u00f8\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2 = {"Lcom/example/whoisspy/database/GameHistoryDao;", "", "delete", "", "gameHistory", "Lcom/example/whoisspy/models/GameHistory;", "(Lcom/example/whoisspy/models/GameHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteById", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGameHistory", "Lkotlinx/coroutines/flow/Flow;", "", "getCivilianWins", "getRecentGameHistory", "limit", "getSpyWins", "getTotalGames", "insert", "", "app_debug"})
@androidx.room.Dao
public abstract interface GameHistoryDao {
    
    /**
     * 获取所有游戏历史记录
     */
    @androidx.room.Query(value = "SELECT * FROM game_history ORDER BY gameTime DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.whoisspy.models.GameHistory>> getAllGameHistory();
    
    /**
     * 获取最近的游戏历史记录
     */
    @androidx.room.Query(value = "SELECT * FROM game_history ORDER BY gameTime DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentGameHistory(int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.whoisspy.models.GameHistory>> $completion);
    
    /**
     * 插入游戏历史记录
     */
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.GameHistory gameHistory, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    /**
     * 删除游戏历史记录
     */
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.GameHistory gameHistory, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * 删除所有游戏历史记录
     */
    @androidx.room.Query(value = "DELETE FROM game_history")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * 根据ID删除游戏历史记录
     */
    @androidx.room.Query(value = "DELETE FROM game_history WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * 获取游戏统计数据
     */
    @androidx.room.Query(value = "SELECT COUNT(*) FROM game_history")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalGames(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * 获取平民胜利次数
     */
    @androidx.room.Query(value = "SELECT COUNT(*) FROM game_history WHERE winnerRole = \'\u5e73\u6c11\' OR winnerRole = \'\u5e73\u6c11\u80dc\u5229\'")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCivilianWins(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * 获取卧底胜利次数
     */
    @androidx.room.Query(value = "SELECT COUNT(*) FROM game_history WHERE winnerRole = \'\u5367\u5e95\' OR winnerRole = \'\u5367\u5e95\u80dc\u5229\'")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSpyWins(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}