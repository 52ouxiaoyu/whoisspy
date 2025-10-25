package com.example.whoisspy.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.Date

/**
 * 词汇对数据模型
 * @property id 唯一标识符
 * @property civilianWord 平民词汇
 * @property spyWord 卧底词汇
 * @property category 词汇类别
 * @property isCustom 是否为自定义词汇
 * @property createTime 创建时间
 */
@Entity(tableName = "word_pairs")
data class WordPair(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val civilianWord: String,
    val spyWord: String,
    val category: String = "默认",
    val isCustom: Boolean = false,
    val createTime: Date = Date()
) {
    // 辅助构造函数，支持简化调用
    @Ignore
    constructor(civilianWord: String, spyWord: String, category: String) : this(
        id = 0, // Explicitly provide default id
        civilianWord = civilianWord,
        spyWord = spyWord,
        category = category,
        isCustom = false, // Explicitly provide default isCustom
        createTime = Date() // Explicitly provide default createTime
    )
}