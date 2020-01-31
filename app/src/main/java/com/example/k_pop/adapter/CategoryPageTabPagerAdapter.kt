package com.example.k_pop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.k_pop.fragment.CategoryPageFragBraodcastTab
import com.example.k_pop.fragment.CategoryPageFragCelebrityTab

class CategoryPageTabPagerAdapter(val tabCount : Int, fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    val celebrityTab : Fragment = CategoryPageFragCelebrityTab()
    val broadcastTab : Fragment = CategoryPageFragBraodcastTab()

    override fun getItem(position: Int): Fragment? {
        return when (position){
            0 -> celebrityTab
            1 -> broadcastTab
            else -> null
        }
    }

    override fun getCount(): Int = tabCount


}