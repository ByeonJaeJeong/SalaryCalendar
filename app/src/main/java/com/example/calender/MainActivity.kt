package com.example.calender

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    lateinit var  navController: NavController //나중에 정의하겠다
    lateinit var  db : MemberDatabase
    var memberList: List<MemberEntity> = listOf<MemberEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       navController= nav_host_fragment.findNavController()
        db = MemberDatabase.getInstance(this)!!



    }



}