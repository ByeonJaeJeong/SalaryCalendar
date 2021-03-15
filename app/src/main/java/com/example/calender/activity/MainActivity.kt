package com.example.calender.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.calender.R
import com.example.calender.db.CalendarDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    lateinit var  navController: NavController //나중에 정의하겠다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //페이지 변환
        navController = nav_host_fragment.findNavController()



    }

    fun setDataFragemnt(fragment: Fragment, title: String){
        val bundle= Bundle()
        bundle.putString("title",title)

        fragment.arguments=bundle

    }

    override fun onDestroy() {
       // MemberDatabase.destoryInstance()
        super.onDestroy()
    }





}