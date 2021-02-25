package com.example.calender.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.calender.MemberDatabase
import com.example.calender.MemberEntity
import com.example.calender.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    lateinit var  navController: NavController //나중에 정의하겠다
    var memberList: List<MemberEntity> = listOf<MemberEntity>()
    lateinit var db: MemberDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //DB생성
       // db = MemberDatabase.getInstance(this)!!

        //페이지 변환
        navController = nav_host_fragment.findNavController()


    }

    override fun onDestroy() {
       // MemberDatabase.destoryInstance()
        super.onDestroy()
    }





}