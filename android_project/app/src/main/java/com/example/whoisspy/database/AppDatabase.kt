package com.example.whoisspy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whoisspy.models.GameHistory
import com.example.whoisspy.models.WordPair
import java.util.Date

/**
 * 应用数据库类
 */
@Database(entities = [WordPair::class, GameHistory::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    
    // 数据访问对象
    abstract fun wordPairDao(): WordPairDao
    abstract fun gameHistoryDao(): GameHistoryDao
    
    companion object {
        // 数据库名称
        private const val DATABASE_NAME = "who_is_spy.db"
        
        // 单例模式
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

/**
 * 日期类型转换器
 */
class DateConverter {
    @androidx.room.TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    
    @androidx.room.TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}