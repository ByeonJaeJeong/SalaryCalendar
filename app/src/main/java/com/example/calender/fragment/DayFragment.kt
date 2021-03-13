package com.example.calender.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calender.R

class DayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var year: String? = null
    private var month: String? = null
    private var day: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터 받아오기
        arguments?.let {
            year = it.getString("year")
            month = it.getString("month")
            day = it.getString("day")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false)
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