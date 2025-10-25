package com.example.whoisspy.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 玩家数据模型
 * @property id 玩家唯一标识符
 * @property name 玩家名称
 * @property role 玩家角色（平民、卧底、白板）
 * @property word 玩家获得的词汇（白板为null）
 * @property isAlive 是否存活
 * @property voteCount 获得的票数
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001-B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003JG\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010(\u001a\u00020\u0005J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/example/whoisspy/models/Player;", "", "id", "", "name", "", "role", "Lcom/example/whoisspy/models/Player$Role;", "word", "isAlive", "", "voteCount", "(ILjava/lang/String;Lcom/example/whoisspy/models/Player$Role;Ljava/lang/String;ZI)V", "getId", "()I", "()Z", "setAlive", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRole", "()Lcom/example/whoisspy/models/Player$Role;", "setRole", "(Lcom/example/whoisspy/models/Player$Role;)V", "getVoteCount", "setVoteCount", "(I)V", "getWord", "setWord", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "getRoleName", "hashCode", "resetVoteCount", "", "toString", "Role", "app_debug"})
public final class Player {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull
    private com.example.whoisspy.models.Player.Role role;
    @org.jetbrains.annotations.Nullable
    private java.lang.String word;
    private boolean isAlive;
    private int voteCount;
    
    public Player(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.Player.Role role, @org.jetbrains.annotations.Nullable
    java.lang.String word, boolean isAlive, int voteCount) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.whoisspy.models.Player.Role getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.Player.Role p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getWord() {
        return null;
    }
    
    public final void setWord(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final boolean isAlive() {
        return false;
    }
    
    public final void setAlive(boolean p0) {
    }
    
    public final int getVoteCount() {
        return 0;
    }
    
    public final void setVoteCount(int p0) {
    }
    
    /**
     * 重置投票数
     */
    public final void resetVoteCount() {
    }
    
    /**
     * 获取角色的中文名称
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoleName() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.whoisspy.models.Player.Role component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.whoisspy.models.Player copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.example.whoisspy.models.Player.Role role, @org.jetbrains.annotations.Nullable
    java.lang.String word, boolean isAlive, int voteCount) {
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
    
    /**
     * 角色枚举
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/example/whoisspy/models/Player$Role;", "", "(Ljava/lang/String;I)V", "CIVILIAN", "SPY", "WHITEBOARD", "app_debug"})
    public static enum Role {
        /*public static final*/ CIVILIAN /* = new CIVILIAN() */,
        /*public static final*/ SPY /* = new SPY() */,
        /*public static final*/ WHITEBOARD /* = new WHITEBOARD() */;
        
        Role() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.example.whoisspy.models.Player.Role> getEntries() {
            return null;
        }
    }
}