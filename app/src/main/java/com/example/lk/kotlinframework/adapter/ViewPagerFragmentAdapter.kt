package com.example.lk.kotlinframework.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by lk on 2018/5/16.
 */
class ViewPagerFragmentAdapter : FragmentPagerAdapter {
    val list: List<Fragment>

    constructor(fm: FragmentManager?, list: List<Fragment>) : super(fm) {
        this.list = list
    }

    override fun getItem(position: Int): Fragment {
        return list.get(position)

    }
    override fun getCount(): Int {
        return list.size
    }

}