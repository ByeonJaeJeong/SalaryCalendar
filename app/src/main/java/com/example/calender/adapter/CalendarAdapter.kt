package com.example.calender.adapter


import android.app.AlertDialog
import android.app.Application
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.*
import android.widget.*
import androidx.navigation.NavController
import androidx.recyclerview.widget.ListAdapter
import com.example.calender.R
import com.example.calender.ViewHolder
import com.example.calender.model.CalendarInfo

class CalendarAdapter(val view: View) :
    ListAdapter<CalendarInfo, ViewHolder>(
        CalendarAdapterDiffcallback()) {
    lateinit var navController: NavController

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
//        navController=Navigation.findNavController(context)

        // 0일경우 날짜표시 x
        if (item.dayOfMonth == 0) {
            holder.dateNumber.visibility = View.GONE
        }
        //일요일
        if (item.dayOfWeek == 0) {
            holder.dateNumber.setTextColor(Color.parseColor("#B22222"))
        }
        //토요일
        if (item.dayOfWeek == 6) {
            holder.dateNumber.setTextColor(Color.BLUE)
        }
        if (item.dayOfMonth != 0) {
            holder.itemView.setOnClickListener {
                Log.v("adapter Click Method", "item.dayOfMonth-0이아닐때")
                // navController.navigate(R.id.action_mainFragment_to_dayFragment, bundleOf("year" to item.year,"month" to  item.month,"day" to item.dayOfMonth))
                val dialog = AlertDialog.Builder(view.context,
                    android.R.style.Theme_Material_Light_NoActionBar).create()
                val edialog: LayoutInflater = LayoutInflater.from(view.context)
                val mView: View = edialog.inflate(R.layout.day_dialog, null)

                val backbtn: ImageButton = mView.findViewById(R.id.workRegistration_backBtn)
                val resultbtn: TextView = mView.findViewById(R.id.workRegistration_resultBtn)
                val workplacebtn: LinearLayout = mView.findViewById(R.id.workplace_btn)
                val workDatebtn: LinearLayout = mView.findViewById(R.id.workDate_btn)
                val workTypebtn: LinearLayout = mView.findViewById(R.id.workType_btn)

                //기본 설정
                val workdate_text : TextView= mView.findViewById(R.id.workDate_text)
                workdate_text.text=item.year.toString()+"."+item.month.toString()+"."+item.dayOfMonth.toString()



                //취소버튼 event
                backbtn.setOnClickListener {
                    val backdialog = AlertDialog.Builder(it.context,android.R.style.Theme_Material_Light_Dialog).create()
                    val backedialog = LayoutInflater.from(it.context)
                    val backView = backedialog.inflate(R.layout.backbtn_dialog, null)
                    backdialog.setCancelable(false)
                    backdialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                    backdialog.setView(backView)
                    backdialog.create()
                    backdialog.show()

                    val yesbtn : Button = backView.findViewById(R.id.yesBtn)
                    val nobtn : Button = backView.findViewById(R.id.noBtn)

                    yesbtn.setOnClickListener {
                        backdialog.dismiss()
                        dialog.dismiss()
                    }
                    nobtn.setOnClickListener {
                        backdialog.dismiss()
                    }

                }
                //취소 버튼 이벤트 종료
                //완료버튼 이벤트
                resultbtn.setOnClickListener{
                    //저장후
                    dialog.dismiss()
                }
                //완료 버튼 이벤트 종료

                //근무지 버튼 이벤트
                workplacebtn.setOnClickListener {

                }
                //근무 일자 이벤트
                workDatebtn.setOnClickListener {

                }
                //근무 유형 버튼 이벤트
                workTypebtn.setOnClickListener {

                }
                dialog.setView(mView)
                dialog.create()
                dialog.show()

            }
        }

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }




}
