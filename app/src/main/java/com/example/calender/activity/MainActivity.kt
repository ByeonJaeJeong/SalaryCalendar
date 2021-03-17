package com.example.calender.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.calender.R
import com.example.calender.adapter.MainFragemntStatePagerAdapter
import com.example.calender.db.CalendarDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    lateinit var  navController: NavController //나중에 정의하겠다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //페이지 변환
       // navController = nav_host_fragment.findNavController()

        configureBottomNavigation()
    }

    private fun configureBottomNavigation(){
        vp_ac_main_frag_pager.adapter= MainFragemntStatePagerAdapter(supportFragmentManager,3)
        tl_ac_main_bottom_menu.setupWithViewPager(vp_ac_main_frag_pager)

        val bottomNaviLayout : View = this.layoutInflater.inflate(R.layout.bottom_navigation_tab,null, false)
        tl_ac_main_bottom_menu.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.calendar_nav_btn) as RelativeLayout
        tl_ac_main_bottom_menu.getTabAt(1)!!.customView = bottomNaviLayout.findViewById(R.id.salary_nav_btn) as RelativeLayout
        tl_ac_main_bottom_menu.getTabAt(2)!!.customView = bottomNaviLayout.findViewById(R.id.more_nav_btn) as RelativeLayout
    }







}