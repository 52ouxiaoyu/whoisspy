package com.example.whoisspy.constants;

/**
 * 游戏常量类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/whoisspy/constants/GameConstants;", "", "()V", "DEFAULT_PLAYER_COUNT", "", "DEFAULT_SPEECH_TIME_LIMIT", "DEFAULT_SPY_COUNT", "DEFAULT_VOTE_TIME_LIMIT", "DEFAULT_WHITEBOARD_COUNT", "EXTRA_CURRENT_PLAYER", "", "EXTRA_GAME_SETTINGS", "EXTRA_PLAYER_INDEX", "MAX_PLAYER_COUNT", "MAX_SPEECH_TIME", "MAX_SPY_COUNT", "MAX_VOTE_TIME", "MAX_WHITEBOARD_COUNT", "MIN_PLAYER_COUNT", "MIN_SPEECH_TIME", "MIN_SPY_COUNT", "MIN_VOTE_TIME", "MIN_WHITEBOARD_COUNT", "STATE_GAME_OVER", "STATE_PREPARING", "STATE_RESULT", "STATE_SPEECH", "STATE_VOTE", "app_debug"})
public final class GameConstants {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STATE_PREPARING = "preparing";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STATE_SPEECH = "speech";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STATE_VOTE = "vote";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STATE_RESULT = "result";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STATE_GAME_OVER = "game_over";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_GAME_SETTINGS = "game_settings";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_CURRENT_PLAYER = "current_player";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_PLAYER_INDEX = "player_index";
    public static final int DEFAULT_PLAYER_COUNT = 8;
    public static final int DEFAULT_SPY_COUNT = 2;
    public static final int DEFAULT_WHITEBOARD_COUNT = 0;
    public static final int DEFAULT_SPEECH_TIME_LIMIT = 60;
    public static final int DEFAULT_VOTE_TIME_LIMIT = 30;
    public static final int MIN_PLAYER_COUNT = 4;
    public static final int MAX_PLAYER_COUNT = 16;
    public static final int MIN_SPY_COUNT = 1;
    public static final int MAX_SPY_COUNT = 4;
    public static final int MIN_WHITEBOARD_COUNT = 0;
    public static final int MAX_WHITEBOARD_COUNT = 2;
    public static final int MIN_SPEECH_TIME = 10;
    public static final int MAX_SPEECH_TIME = 120;
    public static final int MIN_VOTE_TIME = 10;
    public static final int MAX_VOTE_TIME = 60;
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.constants.GameConstants INSTANCE = null;
    
    private GameConstants() {
        super();
    }
}