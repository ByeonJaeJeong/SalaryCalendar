package com.example.calender.adapter


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import com.example.calender.BottomDialogFragment
import com.example.calender.R
import com.example.calender.ViewHolder
import com.example.calender.fragment.MainFragmentDirections
import com.example.calender.model.CalendarInfo


class CalendarAdapter(val context: View) :
    ListAdapter<CalendarInfo,ViewHolder>(
            CalendarAdapterDiffcallback()) {
    lateinit var navController: NavController

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =getItem(position)
        navController=Navigation.findNavController(context)

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
        if(item.dayOfMonth != 0){
            holder.itemView.setOnClickListener {
                Log.v("adapter Click Method", "item.dayOfMonth-0이아닐때")

                navController.navigate(R.id.action_mainFragment_to_dayFragment, bundleOf("year" to item.year,"month" to  item.month,"day" to item.dayOfMonth))

            }
        }

    holder.bind(item)
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }



}

