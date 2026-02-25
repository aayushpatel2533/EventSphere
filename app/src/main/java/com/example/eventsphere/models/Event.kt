package com.example.eventsphere.models

data class Event(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val location: String = "",
    val date: String = "",
    val time: String = "",
    val imageUrl: String = "",
    val organizerId: String = "",
    val organizerName: String = "",
    val rsvpList: List<String> = emptyList(),
    val category: String = "General",
    val createdAt: Long = System.currentTimeMillis()
)