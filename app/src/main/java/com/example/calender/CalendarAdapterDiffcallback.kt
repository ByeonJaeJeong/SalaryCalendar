package com.example.calender

import androidx.recyclerview.widget.DiffUtil
import com.example.calender.model.CalendarInfo

class CalendarAdapterDiffcallback : DiffUtil.ItemCallback<CalendarInfo>() {
    override fun areItemsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
       return oldItem.dayOfMonth == newItem.dayOfMonth  //예전의 날짜와 지금의 날짜가 같은지 여부를 불리언으로 리턴
    }

    override fun areContentsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
        return oldItem == newItem       //Calender Info 가 지금것과 예전것이 같은지 여부 판단
    }
}