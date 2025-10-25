package com.example.whoisspy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whoisspy.R

import android.view.View

/**
 * 发言记录数据类
 */
data class SpeechRecord(val playerName: String, val content: String)

/**
 * 发言记录适配器
 */
class SpeechAdapter(private val speeches: List<SpeechRecord>) : 
    RecyclerView.Adapter<SpeechAdapter.SpeechViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeechViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_speech, parent, false)
        return SpeechViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpeechViewHolder, position: Int) {
        val speech = speeches[position]
        holder.bind(speech)
    }

    override fun getItemCount(): Int = speeches.size

    inner class SpeechViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerName: TextView = itemView.findViewById(R.id.textViewSpeechPlayer)
        private val content: TextView = itemView.findViewById(R.id.textViewSpeechContent)

        fun bind(speech: SpeechRecord) {
            playerName.text = speech.playerName
            content.text = speech.content
        }
    }
}