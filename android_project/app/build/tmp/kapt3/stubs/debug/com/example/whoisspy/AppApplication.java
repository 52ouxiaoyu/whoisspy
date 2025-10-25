package com.example.whoisspy;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.example.whoisspy.managers.WordManager;

/**
 * 应用程序类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/example/whoisspy/AppApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "setupTheme", "Companion", "app_debug"})
public final class AppApplication extends android.app.Application {
    private static android.content.Context appContext;
    @org.jetbrains.annotations.NotNull
    public static final com.example.whoisspy.AppApplication.Companion Companion = null;
    
    public AppApplication() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    /**
     * 设置应用主题
     */
    private final void setupTheme() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/whoisspy/AppApplication$Companion;", "", "()V", "<set-?>", "Landroid/content/Context;", "appContext", "getAppContext", "()Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.content.Context getAppContext() {
            return null;
        }
    }
}