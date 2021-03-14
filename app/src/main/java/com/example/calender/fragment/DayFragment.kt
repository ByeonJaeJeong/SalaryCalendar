package com.example.calender.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.calender.R
import kotlinx.android.synthetic.main.day_dialog.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class DayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var year: Int? = 0
    private var month: Int? = 0
    private var day: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터 받아오기

        arguments?.let {
            var calendar=Calendar.getInstance()
            year = it.getInt("year")
            month = it.getInt("month")
            day = it.getInt("day")
            Log.v("DayFragment",year.toString()+month.toString()+day.toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var workdate_text : TextView= view.findViewById(R.id.workDate_text)
        workdate_text.text=year.toString()+"."+month.toString()+"."+day.toString()

    }
    companion object {
    //데이터 전달
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DayFragment().apply {
                    arguments = Bundle().apply {
                        //putString(ARG_PARAM1, param1)
                        //putString(ARG_PARAM2, param2)
                    }
                }
    }
}