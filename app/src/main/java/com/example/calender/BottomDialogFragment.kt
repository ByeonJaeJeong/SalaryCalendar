package com.example.calender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.calender.R
import kotlinx.android.synthetic.main.worktype_dialog.view.*

class BottomDialogFragment(val itemClick: (Int) -> Unit):
BottomSheetDialogFragment(){
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View =
            inflater.inflate(R.layout.worktype_dialog, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.hour_pay.setOnClickListener {
            itemClick(0)
            dialog?.dismiss()
        }
        view.day_pay.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
        view.case_pay.setOnClickListener{
            itemClick(2)
            dialog?.dismiss()
        }
        view.holiday_pay.setOnClickListener {
            itemClick(3)
            dialog?.dismiss()
        }
        view.absnc.setOnClickListener {
            itemClick(4)
            dialog?.dismiss()
        }
    }
}