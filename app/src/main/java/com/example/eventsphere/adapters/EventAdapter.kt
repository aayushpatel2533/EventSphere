package com.example.eventsphere.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventsphere.databinding.ItemEventBinding
import com.example.eventsphere.models.Event

class EventAdapter(
    private var events: MutableList<Event>,
    private val onClick: (Event) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        with(holder.binding) {
            tvTitle.text      = event.title
            tvCategory.text   = event.category
            tvDateTime.text   = "📅 ${event.date} • ${event.time}"
            tvLocation.text   = "📍 ${event.location}"
            tvRsvpCount.text  = "👥 ${event.rsvpList.size} going"
            tvOrganizer.text  = "by ${event.organizerName}"

            if (event.imageUrl.isNotEmpty()) {
                Glide.with(root.context).load(event.imageUrl).into(ivEventImage)
            }

            root.setOnClickListener { onClick(event) }
        }
    }

    override fun getItemCount() = events.size

    fun updateList(newList: List<Event>) {
        events.clear()
        events.addAll(newList)
        notifyDataSetChanged()
    }
}