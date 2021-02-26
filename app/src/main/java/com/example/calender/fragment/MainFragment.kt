package com.example.calender.fragment

import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.example.calender.R
import androidx.databinding.DataBindingUtil
import com.example.calender.adapter.CalendarAdapter
import com.example.calender.databinding.FragmentMainBinding
import com.example.calender.model.CalendarInfo



class MainFragment : Fragment() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding :FragmentMainBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        val adapter =CalendarAdapter()
        binding.calendar.adapter =adapter
        val calendar = Calendar.getInstance()
        calendar.timeInMillis= System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH,1)
        val tmpCal= calendar.timeInMillis
        calendar.timeInMillis=tmpCal
        val year=calendar.get(Calendar.YEAR).toString()
        val maxDate =calendar.getActualMaximum(Calendar.DATE)
        val week =calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val list = MutableList(week, init = { CalendarInfo() })
        for (i in 1..maxDate) {
            list.add(CalendarInfo(month, i))
        }
        adapter.submitList(list)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
@BindingAdapter("setDate")
fun TextView.setDate(item: CalendarInfo?){
    item?.let {
        text= it.dayOfMonth.toString()
    }
}
@BindingAdapter("setmonth")
fun TextView.setMonth(item: CalendarInfo?){
    item?.let {
        text= it.month.toString()
    }
}
