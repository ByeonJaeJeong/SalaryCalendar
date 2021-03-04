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
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import com.example.calender.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.adapter.CalendarAdapter
import com.example.calender.databinding.FragmentMainBinding
import com.example.calender.databinding.HeaderItemBinding
import com.example.calender.model.CalendarInfo
import com.example.calender.model.WorkInfo
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.item_calendar_header.*
import java.time.Year


class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

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
        calendar.timeInMillis= System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH,1)
        //달력에서 현재 시간 날짜 정보를 가져옴
        val tmpCal= calendar.timeInMillis
        calendar.timeInMillis=tmpCal

        val year=calendar.get(Calendar.YEAR)
        val maxDate =calendar.getActualMaximum(Calendar.DATE)
        val week =calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val workInfo = WorkInfo()
        binding.selectDate.setText(year.toString()+"년"+month.toString()+"월")
        Log.v("첫날",week.toString())
        val list = MutableList(week, init = { CalendarInfo(year,month,0) })
        for (i in 1..maxDate) {
            val week_day = (week+i-1)%7
            list.add(CalendarInfo(year,month,i,week_day))
        }


        adapter.submitList(list)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)
        lMonthBtn.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.lMonthBtn->{
                val text=R.id.select_date.toString()

                Log.v("출력",text.toString())
            }
        }
    }

}
@BindingAdapter("setDate")
fun TextView.setDate(item: CalendarInfo?){
    item?.let {
        text= it.dayOfMonth.toString()
    }
}


