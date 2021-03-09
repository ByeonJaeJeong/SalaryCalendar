package com.example.calender

import android.app.AlertDialog
import android.icu.util.Calendar
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.calender.databinding.DayItemBinding
import com.example.calender.model.CalendarInfo

class ViewHolder private constructor(
        private val binding:DayItemBinding) : RecyclerView.ViewHolder(binding.root){
        val dateNumber : TextView =binding.textViewDateNumber

        init {
            Log.v("Tag", "ViewHolder - init() called")
        }

        fun bind(item: CalendarInfo){
                binding.calendarInfo=item
                binding.executePendingBindings()
                binding.CalendarBackground.setOnClickListener{
                        Log.v("itemselected",item.toString()) //item 은 CalendarInfo 정보
                        val dialog = AlertDialog.Builder(it.context).create()
                        val edialog : LayoutInflater = LayoutInflater.from(it.context)
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
                       // year.value=calendar.get(Calendar.YEAR)
                       // month.value=calendar.get(Calendar.MONTH)

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
                               // makeMonthDate(year.value ,month.value-1)
                                dialog.dismiss()
                                dialog.cancel()
                        }
                        dialog.setView(mView)
                        dialog.create()
                        dialog.show()
                }
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
