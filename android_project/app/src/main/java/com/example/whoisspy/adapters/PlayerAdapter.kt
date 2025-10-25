package com.example.whoisspy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whoisspy.R
import com.example.whoisspy.models.Player

/**
 * 玩家列表适配器
 */
class PlayerAdapter(
    private val players: List<Player>,
    private val onPlayerClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int = players.size

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val statusIcon: ImageView = itemView.findViewById(R.id.imageViewPlayerStatus)
        private val playerName: TextView = itemView.findViewById(R.id.textViewPlayerName)

        fun bind(player: Player) {
            // 设置玩家名称
            playerName.text = player.name
            
            // 设置玩家状态图标
            statusIcon.setImageResource(
                if (player.isAlive) {
                    R.drawable.ic_player_alive
                } else {
                    R.drawable.ic_player_dead
                }
            )

            // 设置点击事件
            itemView.setOnClickListener {
                if (player.isAlive) {
                    onPlayerClick(player)
                }
            }
        }
    }
}