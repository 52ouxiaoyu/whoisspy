package com.example.whoisspy.models;

import android.os.Parcelable;
import kotlinx.parcelize.Parcelize;

/**
 * 游戏设置数据模型
 * @property playerCount 玩家数量
 * @property spyCount 卧底数量
 * @property whiteboardCount 白板数量
 * @property gameMode 游戏模式
 * @property wordCategory 词汇类别
 * @property speechTime 发言时间（秒）
 * @property voteTime 投票时间（秒）
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\u0006\u0010#\u001a\u00020\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010%\u001a\u00020 J\t\u0010&\u001a\u00020\u0007H\u00d6\u0001J\u0019\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006,"}, d2 = {"Lcom/example/whoisspy/models/GameSettings;", "Landroid/os/Parcelable;", "playerCount", "", "spyCount", "whiteboardCount", "gameMode", "", "wordCategory", "(IIILjava/lang/String;Ljava/lang/String;)V", "getGameMode", "()Ljava/lang/String;", "setGameMode", "(Ljava/lang/String;)V", "getPlayerCount", "()I", "setPlayerCount", "(I)V", "getSpyCount", "setSpyCount", "getWhiteboardCount", "setWhiteboardCount", "getWordCategory", "setWordCategory", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "getCivilianCount", "hashCode", "isValid", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize
public final class GameSettings implements android.os.Parcelable {
    private int playerCount;
    private int spyCount;
    private int whiteboardCount;
    @org.jetbrains.annotations.NotNull
    private java.lang.String gameMode;
    @org.jetbrains.annotations.NotNull
    private java.lang.String wordCategory;
    
    public GameSettings(int playerCount, int spyCount, int whiteboardCount, @org.jetbrains.annotations.NotNull
    java.lang.String gameMode, @org.jetbrains.annotations.NotNull
    java.lang.String wordCategory) {
        super();
    }
    
    public final int getPlayerCount() {
        return 0;
    }
    
    public final void setPlayerCount(int p0) {
    }
    
    public final int getSpyCount() {
        return 0;
    }
    
    public final void setSpyCount(int p0) {
    }
    
    public final int getWhiteboardCount() {
        return 0;
    }
    
    public final void setWhiteboardCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGameMode() {
        return null;
    }
    
    public final void setGameMode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWordCategory() {
        return null;
    }
    
    public final void setWordCategory(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    /**
     * 验证设置是否有效
     */
    public final boolean isValid() {
        return false;
    }
    
    /**
     * 获取平民数量
     */
    public final int getCivilianCount() {
        return 0;
    }
    
    public GameSettings() {
        super();
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
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.whoisspy.models.GameSettings copy(int playerCount, int spyCount, int whiteboardCount, @org.jetbrains.annotations.NotNull
    java.lang.String gameMode, @org.jetbrains.annotations.NotNull
    java.lang.String wordCategory) {
        return null;
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
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
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
}