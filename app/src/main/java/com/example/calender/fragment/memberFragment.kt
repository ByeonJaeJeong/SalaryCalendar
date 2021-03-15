package com.example.calender.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calender.R
import kotlinx.android.synthetic.main.fragment_member.*


class memberFragment : Fragment() , View.OnClickListener{
    lateinit var navController: NavController
    lateinit var db : MemberDatabase



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
        memberJoin_btn.setOnClickListener(this)

    }//view oncreated

    override fun onClick(v: View?) {
        when(v?.id){
        R.id.memberJoin_btn->{
            if (memberPW_edit.text.toString() == memberPW_edit2.text.toString()) {
                var member = MemberEntity(
                    memberEmail_edit.text.toString(),
                    memberPW_edit.text.toString(),
                    memberName_edit.text.toString()
                )
                Toast.makeText(v.context, "회원가입 완료", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(v.context, "패스워드가 맞지않습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}