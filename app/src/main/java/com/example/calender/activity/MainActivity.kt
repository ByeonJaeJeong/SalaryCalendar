package com.example.calender.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.calender.R
import com.example.calender.adapter.NavigationViewpagerAdapter
import com.example.calender.fragment.MainFragment
import com.example.calender.fragment.MoreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    //사용자와 의 상호작용을 할수있게 준비하는 작업
    //lateinit var  navController: NavController //나중에 정의하겠다
    private val fragmentCalendar by lazy { MainFragment() }
    private val fragmentPay by lazy { MainFragment() }
    private val fragmentMore by lazy { MoreFragment() }
    private val fragments: List<Fragment> = listOf( fragmentCalendar, fragmentPay, fragmentMore )
    private val pagerAdapter: NavigationViewpagerAdapter by lazy { NavigationViewpagerAdapter(this, fragments) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //페이지 변환
       // navController = nav_host_fragment.findNavController()
        initViewPager()
        initNavigationBar()


    }

    private fun initNavigationBar(){
        bottom_navigation.run{
            this.setOnNavigationItemSelectedListener{
                val page = when(it.itemId){
                    R.id.calendar_icon -> 0
                    R.id.piggy_icon -> 1
                    R.id.more_icon -> 2
                    else -> error("initViewPager error"+it.itemId.toString())
                }
                if(page != view_pager.currentItem){ Log.v("page data",page.toString() +","+view_pager.currentItem.toString())
                    view_pager.currentItem=page
                }
                true
            }
            selectedItemId = R.id.calendar_icon
        }
    }

    private fun initViewPager() {
        view_pager.run {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    val navigation = when (position) {
                        0 -> R.id.calendar_icon
                        1 -> R.id.piggy_icon
                        2 -> R.id.more_icon
                        else -> error("initViewPager error"+position.toString())
                    }
                    if (bottom_navigation.selectedItemId != navigation) {
                        bottom_navigation.selectedItemId = navigation
                    }
                }
            })
        }
    }
}