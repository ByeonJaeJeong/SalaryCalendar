package com.example.calender

import android.app.AlertDialog
import android.icu.util.Calendar
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
                        val dialog = AlertDialog.Builder(it.context,android.R.style.Theme_Material_Light_NoActionBar).create()
                        val edialog : LayoutInflater = LayoutInflater.from(it.context)
                        val mView : View = edialog.inflate(R.layout.day_dialog,null)


                        val cancel : ImageButton = mView.findViewById(R.id.workRegistration_backBtn)
                        val save : Button = mView.findViewById(R.id.workRegistration_resultBtn)
                        val workdate :TextView = mView.findViewById(R.id.workDate_text)

                        val workDateBtn: LinearLayout = mView.findViewById(R.id.workDate_btn)
                        val workplaceBtn : LinearLayout = mView.findViewById(R.id.workplace_btn)
                        val workTypeBtn : LinearLayout = mView.findViewById(R.id.workType_btn)

                        workdate.text=item.year.toString()+"."+item.month.toString()+"."+item.dayOfMonth.toString()

                        workDateBtn.setOnClickListener{
                                Log.v("ViewHolder","workDateBtn Click")
                        }
                        workplaceBtn.setOnClickListener {
                                Log.v("ViewHolder","workplaceBtn Click")
                        }
                        workTypeBtn.setOnClickListener {
                                Log.v("ViewHolder","workTypeBtn Click")
                        }


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
