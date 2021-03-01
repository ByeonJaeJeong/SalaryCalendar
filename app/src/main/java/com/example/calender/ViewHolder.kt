package com.example.calender

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calender.databinding.DayItemBinding
import com.example.calender.model.CalendarInfo

class ViewHolder private constructor(
        private val binding:DayItemBinding) : RecyclerView.ViewHolder(binding.root){
        val dateHeader =binding.CalendarBackground
        val dateNumber : TextView =binding.textViewDateNumber

        fun bind(item: CalendarInfo){
                binding.calendarInfo=item
                binding.executePendingBindings()
        }

        companion object{
                fun  from(parent: ViewGroup): ViewHolder{
                        val layoutInflater=
                                LayoutInflater.from(parent.context)
                        val binding=DayItemBinding.inflate(layoutInflater,parent,false)
                        return ViewHolder(binding)
                }
        }
}
