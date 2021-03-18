package com.example.calender.adapter

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.calender.R
import com.example.calender.fragment.LoginFragment
import com.example.calender.fragment.MainFragment
import com.example.calender.fragment.MemberFragment

private const val  ARG_PARAM1= "param1"
class NavigationViewpagerAdapter(activity: AppCompatActivity, private val fragments: List<Fragment>)
    : FragmentStateAdapter(activity)
{
    override fun getItemCount(): Int =fragments.size

    override fun createFragment(position: Int): Fragment =fragments[position]

}