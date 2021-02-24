package com.example.calender

import androidx.recyclerview.widget.DiffUtil
import com.example.calender.util.CalendarInfo

class CalendarAdapterDiffcallback : DiffUtil.ItemCallback<CalendarInfo>() {
    override fun areItemsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
       return oldItem.dayOfMonth == newItem.dayOfMonth
    }

    override fun areContentsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
        return oldItem == newItem
    }
}