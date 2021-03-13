package com.example.calender

import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.calender.databinding.DayItemBinding
import com.example.calender.fragment.MainFragment
import com.example.calender.model.CalendarInfo

class ViewHolder private constructor(
        private val binding:DayItemBinding) : RecyclerView.ViewHolder(binding.root){
        val dateNumber : TextView =binding.textViewDateNumber
        lateinit var navController: NavController

        init {
            Log.v("Tag", "ViewHolder - init() called")

        }

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
