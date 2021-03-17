package com.example.calender.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.calender.fragment.LoginFragment
import com.example.calender.fragment.MainFragment
import com.example.calender.fragment.MemberFragment

class MainFragemntStatePagerAdapter(fm: FragmentManager, val fragmentCont :Int) :FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = fragmentCont

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return LoginFragment()
            1 -> return LoginFragment()
            2 -> return MemberFragment()
            else-> return LoginFragment()
        }
    }
}