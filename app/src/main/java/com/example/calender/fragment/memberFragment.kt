package com.example.calender.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.MainActivity
import com.example.calender.MemberDatabase
import com.example.calender.MemberEntity
import com.example.calender.R
import kotlinx.android.synthetic.main.fragment_member.*


class memberFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var db : MemberDatabase

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_member, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)

         memberJoin_btn.setOnClickListener {
            if (memberPW_edit.text.toString() == memberPW_edit2.text.toString()) {
                var member = MemberEntity(
                    null,
                    memberEmail_edit.text.toString(),
                    memberPW_edit.text.toString(),
                    memberName_edit.text.toString()
                )

            } else {
                Toast.makeText(view.context, "패스워드가 맞지않습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }//view oncreated

}