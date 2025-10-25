package com.example.whoisspy.managers

import android.content.Context
import com.example.whoisspy.models.WordPair
import com.example.whoisspy.repositories.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 词库管理类
 */
class WordManager private constructor() {
    
    private lateinit var wordRepository: WordRepository
    private var isInitialized = false
    
    /**
     * 初始化词库管理器
     */
    fun initialize(context: Context) {
        if (isInitialized) return
        
        wordRepository = WordRepository.getInstance(context)
        
        // 在后台线程初始化默认词库
        CoroutineScope(Dispatchers.IO).launch {
            initializeDefaultWords()
        }
        
        isInitialized = true
    }
    
    /**
     * 初始化默认词库
     */
    private suspend fun initializeDefaultWords() {
        // 检查是否已经有默认词库
        val defaultWords = wordRepository.defaultWordPairs.value
        if (defaultWords.isNullOrEmpty()) {
            // 添加默认词汇对
            val defaultWordPairs = listOf(
                // 科技类
                WordPair(civilianWord = "电脑", spyWord = "手机", category = "科技", isCustom = false),
                WordPair(civilianWord = "安卓", spyWord = "苹果", category = "科技", isCustom = false),
                WordPair(civilianWord = "键盘", spyWord = "鼠标", category = "科技", isCustom = false),
                WordPair(civilianWord = "微信", spyWord = "QQ", category = "科技", isCustom = false),
                WordPair(civilianWord = "耳机", spyWord = "音箱", category = "科技", isCustom = false),
                
                // 食物类
                WordPair(civilianWord = "火锅", spyWord = "烧烤", category = "食物", isCustom = false),
                WordPair(civilianWord = "可乐", spyWord = "雪碧", category = "食物", isCustom = false),
                WordPair(civilianWord = "米饭", spyWord = "面条", category = "食物", isCustom = false),
                WordPair(civilianWord = "苹果", spyWord = "香蕉", category = "食物", isCustom = false),
                WordPair(civilianWord = "蛋糕", spyWord = "面包", category = "食物", isCustom = false),
                
                // 人物类
                WordPair(civilianWord = "老师", spyWord = "学生", category = "人物", isCustom = false),
                WordPair(civilianWord = "医生", spyWord = "护士", category = "人物", isCustom = false),
                WordPair(civilianWord = "警察", spyWord = "小偷", category = "人物", isCustom = false),
                WordPair(civilianWord = "爸爸", spyWord = "妈妈", category = "人物", isCustom = false),
                WordPair(civilianWord = "演员", spyWord = "歌手", category = "人物", isCustom = false),
                
                // 动物类
                WordPair(civilianWord = "老虎", spyWord = "狮子", category = "动物", isCustom = false),
                WordPair(civilianWord = "猫", spyWord = "狗", category = "动物", isCustom = false),
                WordPair(civilianWord = "大象", spyWord = "长颈鹿", category = "动物", isCustom = false),
                WordPair(civilianWord = "鱼", spyWord = "虾", category = "动物", isCustom = false),
                WordPair(civilianWord = "猴子", spyWord = "猩猩", category = "动物", isCustom = false),
                
                // 地点类
                WordPair(civilianWord = "学校", spyWord = "公司", category = "地点", isCustom = false),
                WordPair(civilianWord = "公园", spyWord = "动物园", category = "地点", isCustom = false),
                WordPair(civilianWord = "餐厅", spyWord = "咖啡厅", category = "地点", isCustom = false),
                WordPair(civilianWord = "北京", spyWord = "上海", category = "地点", isCustom = false),
                WordPair(civilianWord = "卧室", spyWord = "客厅", category = "地点", isCustom = false),
                
                // 运动类
                WordPair(civilianWord = "篮球", spyWord = "足球", category = "运动", isCustom = false),
                WordPair(civilianWord = "游泳", spyWord = "跑步", category = "运动", isCustom = false),
                WordPair(civilianWord = "乒乓球", spyWord = "羽毛球", category = "运动", isCustom = false),
                WordPair(civilianWord = "瑜伽", spyWord = "健身", category = "运动", isCustom = false),
                WordPair(civilianWord = "网球", spyWord = "排球", category = "运动", isCustom = false),
                
                // 其他类
                WordPair(civilianWord = "太阳", spyWord = "月亮", category = "其他", isCustom = false),
                WordPair(civilianWord = "白天", spyWord = "夜晚", category = "其他", isCustom = false),
                WordPair(civilianWord = "雨伞", spyWord = "雨衣", category = "其他", isCustom = false),
                WordPair(civilianWord = "书本", spyWord = "杂志", category = "其他", isCustom = false),
                WordPair(civilianWord = "春天", spyWord = "秋天", category = "其他", isCustom = false),
                WordPair(civilianWord = "热水", spyWord = "冷水", category = "其他", isCustom = false),
                WordPair(civilianWord = "电视", spyWord = "电影", category = "其他", isCustom = false),
                WordPair(civilianWord = "鞋子", spyWord = "袜子", category = "其他", isCustom = false),
                WordPair(civilianWord = "红色", spyWord = "绿色", category = "其他", isCustom = false),
                WordPair(civilianWord = "铅笔", spyWord = "钢笔", category = "其他", isCustom = false)
            )
            
            wordRepository.insertAllWordPairs(defaultWordPairs)
        }
    }
    
    companion object {
        @Volatile
        private var INSTANCE: WordManager? = null
        
        fun initialize(context: Context) {
            getInstance().initialize(context)
        }
        
        fun getInstance(): WordManager {
            return INSTANCE ?: synchronized(this) {
                val instance = WordManager()
                INSTANCE = instance
                instance
            }
        }
    }
}