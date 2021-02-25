package com.example.calender.adapter


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calender.CalendarAdapterDiffcallback
import com.example.calender.ViewHolder
import com.example.calender.util.CalendarInfo
import java.util.*


class CalendarAdapter :
    ListAdapter<CalendarInfo,ViewHolder>(
            CalendarAdapterDiffcallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =getItem(position)
        if(item.dayOfMonth == 0){
            holder.dateNumber.visibility= View.GONE
    }
    holder.bind(item)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
}