package com.example.k_pop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.k_pop.fragment.*

class MainBottomTabAdapter(private val fragmentCount: Int, fm: FragmentManager) : FragmentStatePagerAdapter(fm){
    val mainPage = MainPageFragment()
    val categoryPage = CategoryPageFragment()
    val mapPage = MapPageFragment()
    val myPage = MyPageFragment()

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> mainPage
            1 -> categoryPage
            2 -> mapPage
            3 -> myPage
            else->null
        }
    }

    override fun getCount(): Int = fragmentCount
}