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
import com.example.calender.databinding.HeaderItemBinding
import com.example.calender.model.CalendarInfo
import kotlinx.android.synthetic.main.item_calendar_header.*
import java.time.Year


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
        //현재 날짜 정보 입력
        val startData= "20210105083000"

        calendar.set(Calendar.YEAR,(startData.substring(0,4).toInt()))
        calendar.set(Calendar.MONTH,(startData.substring(4,6)).toInt()-1)
        calendar.set(Calendar.DATE,(startData.substring(6,8)).toInt())
        calendar.set(Calendar.HOUR,(startData.substring(8,10)).toInt())
        calendar.set(Calendar.MINUTE,(startData.substring(10,12)).toInt())
        calendar.set(Calendar.SECOND,(startData.substring(12,14)).toInt())
        //calendar.timeInMillis= System.currentTimeMillis()
        //calendar.set(Calendar.DAY_OF_MONTH,1)
        //달력에서 현재 시간 날짜 정보를 가져옴
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
@BindingAdapter("setMonth")
fun TextView.setMonth(item: CalendarInfo?){
    item?.let {
        text= it.month.toString()
    }
}

