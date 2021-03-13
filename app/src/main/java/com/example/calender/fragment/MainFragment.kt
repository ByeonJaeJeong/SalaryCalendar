package com.example.calender.fragment

import android.app.AlertDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.calender.R
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.BottomDialogFragment
import com.example.calender.activity.MainActivity
import com.example.calender.adapter.CalendarAdapter
import com.example.calender.databinding.FragmentMainBinding
import com.example.calender.model.CalendarInfo
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener {
    lateinit var adapter : CalendarAdapter
    lateinit var navController: NavController
    lateinit var calendar: Calendar
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)


        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter=CalendarAdapter(view)
        navController= Navigation.findNavController(view)
        leftButton.setOnClickListener(this)
        rightButton.setOnClickListener(this)
        select_date.setOnClickListener(this)

        calendar = Calendar.getInstance()
        //현재 날짜 정보 입력
        calendar.timeInMillis= System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH,1)
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)

        makeMonthDate(year,month)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            //월 변경버튼(좌)
            R.id.leftButton->{
                calendar.add(Calendar.MONTH,-1)
                val year=calendar.get(Calendar.YEAR)
                val month=calendar.get(Calendar.MONTH)
                Log.v("leftbutton",year.toString()+"년"+month.toString()+"월")
               makeMonthDate(year,month)


            }
            //월 변경 버튼(우)
            R.id.rightButton->{
                calendar.add(Calendar.MONTH,+1)
                val year=calendar.get(Calendar.YEAR)
                val month=calendar.get(Calendar.MONTH)
                Log.v("rightbutton",year.toString()+"년"+month.toString()+"월")
                makeMonthDate(year,month)
            }
            //연월 설정 button
            R.id.select_date->{
                val dialog = AlertDialog.Builder(context).create()
                val edialog : LayoutInflater = LayoutInflater.from(context)
                val mView : View = edialog.inflate(R.layout.month_dialog,null)

                val year : NumberPicker = mView.findViewById(R.id.picker_year)
                val month : NumberPicker = mView.findViewById(R.id.picker_month)
                val cancel : Button = mView.findViewById(R.id.cancel_button_datepicker)
                val save : Button = mView.findViewById(R.id.save_button_datepicker)

                //  순환 안되게 막기
                year.wrapSelectorWheel = false
                month.wrapSelectorWheel = false

                //  editText 설정 해제
                year.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
                month.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS


                // 현재값 설정
                year.value=calendar.get(Calendar.YEAR)
                month.value=calendar.get(Calendar.MONTH)

                //  최소값 설정
                year.minValue = 2020
                month.minValue = 1

                //  최대값 설정
                year.maxValue = 2024
                month.maxValue = 12


                //년 월 붙여서 출력하기
                year.displayedValues=
                    arrayOf("2020년", "2021년", "2022년", "2023년", "2024년")

                month.displayedValues =
                    arrayOf("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월")
                //  취소 버튼 클릭 시
                cancel.setOnClickListener {
                    dialog.dismiss()
                    dialog.cancel()
                }

                //  완료 버튼 클릭 시
                save.setOnClickListener {
                    makeMonthDate(year.value ,month.value-1)
                    dialog.dismiss()
                    dialog.cancel()
                    val orderBottomDialogFragment: BottomDialogFragment = BottomDialogFragment {
                        when (it) {
                            0 -> Toast.makeText(this.context,"item1", Toast.LENGTH_SHORT)
                            1 ->Log.v("ViewHolder","item2")
                        }
                    }
                    orderBottomDialogFragment.show(parentFragmentManager,orderBottomDialogFragment.tag)
                }
                dialog.setView(mView)
                dialog.create()
                dialog.show()
            }

        }
    }
    private fun makeMonthDate(year: Int,month: Int){
        binding.calendar.adapter =adapter
        calendar = Calendar.getInstance()
        //현재 날짜 정보 입력
        calendar.set(Calendar.YEAR,year)
        calendar.set(Calendar.MONTH,month)
        val year=calendar.get(Calendar.YEAR)
        val maxDate =calendar.getActualMaximum(Calendar.DATE)
        val week =calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH)+1
        binding.selectDate.setText(year.toString()+"년"+month.toString()+"월")
        Log.v("첫날",week.toString())
        val list = MutableList(week, init = { CalendarInfo(year,month,0) })
        for (i in 1..maxDate) {
            val week_day = (week+i-1) % 7
            list.add(CalendarInfo(year,month,i,week_day))
        }

        adapter.submitList(list)
    }
    //새로고침 하는 메소드
    fun refreshFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        var ft: FragmentTransaction = fragmentManager.beginTransaction()
        ft.detach(fragment).attach(fragment).commit()
    }

}
@BindingAdapter("setDate")
fun TextView.setDate(item: CalendarInfo?){
    item?.let {
        text= it.dayOfMonth.toString()
    }
}


