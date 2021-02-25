package com.example.calender

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calender.databinding.DayItemBinding
import com.example.calender.util.CalendarInfo

class ViewHolder private constructor(val binding:DayItemBinding) : RecyclerView.ViewHolder(binding.root){
        val background =binding.CalendarBackground
        val dateNumber =binding.textViewDateNumber

        fun bind(item:CalendarInfo){
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