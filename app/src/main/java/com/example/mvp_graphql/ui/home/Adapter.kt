package com.example.mvp_graphql.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_graphql.Data.Restaurants
import com.example.mvp_graphql.databinding.RestItemBinding


class Adapter :
    ListAdapter<Restaurants, Adapter.RestaurantViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurants) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurants>() {
        override fun areItemsTheSame(oldItem: Restaurants, newItem: Restaurants) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurants, newItem: Restaurants) =
            oldItem == newItem
    }
}