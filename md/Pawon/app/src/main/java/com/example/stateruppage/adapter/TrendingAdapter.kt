package com.example.stateruppage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.data.Trending
import com.example.stateruppage.databinding.ListItemTrendingBinding

class TrendingAdapter(
    private val trendingList: List<Trending>,
    private val onItemClick: (Trending) -> Unit
) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val binding = ListItemTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trendingItem = trendingList[position]
        holder.bind(trendingItem)
    }

    override fun getItemCount(): Int = trendingList.size

    inner class TrendingViewHolder(private val binding: ListItemTrendingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(trending: Trending) {
            binding.tvPlaceName.text = trending.title
            binding.tvVote.text = trending.votes
            binding.imgThumb.setImageResource(trending.imageResId)

            // Set click listener
            itemView.setOnClickListener {
                onItemClick(trending)
            }
        }
    }
}
