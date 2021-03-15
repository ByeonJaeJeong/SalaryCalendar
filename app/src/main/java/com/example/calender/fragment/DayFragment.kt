package com.example.calender.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.BottomDialogFragment
import com.example.calender.R
import kotlinx.android.synthetic.main.day_dialog.*
import kotlinx.android.synthetic.main.day_dialog.view.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class DayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var year: Int? = 0
    private var month: Int? = 0
    private var day: Int? = 0
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터 받아오기

        arguments?.let {
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
        navController= Navigation.findNavController(view)
        var workdate_text : TextView= view.findViewById(R.id.workDate_text)
        workdate_text.text=year.toString()+"."+month.toString()+"."+day.toString()
        var workType_text :TextView =view.findViewById(R.id.workType_text)
        var worktype_btn : LinearLayout = view.findViewById(R.id.workType_btn)
        worktype_btn.setOnClickListener {
            val orderBottomDialogFragment: BottomDialogFragment = BottomDialogFragment {
                when (it) {
                    0 -> workType_text.text="시급"
                    1 -> workType_text.text="일급"
                    2 -> workType_text.text="건 별"
                    3 -> workType_text.text="휴무"
                    4 -> workType_text.text="결근"
                }
            }
            orderBottomDialogFragment.show(parentFragmentManager,orderBottomDialogFragment.tag)
        }

        val workRegistration_backBtn :ImageButton = view.findViewById(R.id.workRegistration_backBtn)
        val workRegistration_resultBtn :TextView =view.findViewById(R.id.workRegistration_resultBtn)

        workRegistration_backBtn.setOnClickListener {
            navController.popBackStack()
        }
        workRegistration_resultBtn.setOnClickListener{
            navController.popBackStack()
        }

    }
   /* companion object {
    //데이터 전달
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DayFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }*/
}