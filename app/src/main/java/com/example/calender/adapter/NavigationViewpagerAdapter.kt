package com.example.calender.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val  ARG_PARAM1= "param1"
class NavigationViewpagerAdapter(activity: AppCompatActivity, private val fragments: List<Fragment>)
    : FragmentStateAdapter(activity)
{
    override fun getItemCount(): Int =fragments.size

    override fun createFragment(position: Int): Fragment =fragments[position]

}