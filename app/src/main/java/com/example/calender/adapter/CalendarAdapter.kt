package com.example.calender.adapter


import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.calender.ViewHolder
import com.example.calender.model.CalendarInfo


class CalendarAdapter :
    ListAdapter<CalendarInfo,ViewHolder>(
            CalendarAdapterDiffcallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =getItem(position)
        // 0일경우 날짜표시 x
        if(item.dayOfMonth == 0){
            holder.dateNumber.visibility= View.GONE
    }
        //일요일
        if(item.dayOfWeek == 0){
            holder.dateNumber.setTextColor(Color.parseColor("#B22222"))
        }
        //토요일
        if(item.dayOfWeek == 6){
            holder.dateNumber.setTextColor(Color.BLUE)
        }

    holder.bind(item)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

}

