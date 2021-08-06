package com.example.myapplication.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_graphql.LaunchListQuery
import com.example.mvp_graphql.databinding.ContentNotifBinding


class AdapterNotif :
    RecyclerView.Adapter<AdapterNotif.ViewHolder>() {

    private var launches: List<LaunchListQuery.Launch> = emptyList()


    fun setData(launches: List<LaunchListQuery.Launch>) {
        this.launches = launches
        notifyDataSetChanged();


    }

    class ViewHolder(val binding: ContentNotifBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContentNotifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((LaunchListQuery.Launch) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches.get(position)
        holder.binding.site.text = launch.site ?: ""
        holder.binding.missionName.text = launch.mission?.name


        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }

    
}