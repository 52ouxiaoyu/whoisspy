package com.example.whoisspy

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.whoisspy.managers.WordManager

/**
 * 应用程序类
 */
class AppApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // 初始化应用程序上下文
        appContext = this
        
        // 初始化词库管理器
        WordManager.initialize(this)
        
        // 设置主题
        setupTheme()
    }
    
    /**
     * 设置应用主题
     */
    private fun setupTheme() {
        val sharedPreferences = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        val themeMode = sharedPreferences.getString("theme_mode", "system")
        
        when (themeMode) {
            "light" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            "dark" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }
    
    companion object {
        lateinit var appContext: Context
            private set
    }
}