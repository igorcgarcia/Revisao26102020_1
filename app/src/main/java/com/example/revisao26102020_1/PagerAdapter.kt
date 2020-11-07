package com.example.revisao26102020_1

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class RegisterAdapter(
    val list: List<String>,
    private val fragments: List<Fragment>,
    manager: FragmentManager
): FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }


}