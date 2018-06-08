package com.example.lk.kotlinframework.ui.acitivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.lk.kotlinframework.R
import com.example.lk.kotlinframework.adapter.ViewPagerFragmentAdapter
import com.example.lk.kotlinframework.mvp.v.fragment.ClassfitionFragment
import com.example.lk.kotlinframework.mvp.v.fragment.HomeFragment
import com.example.lk.kotlinframework.mvp.v.view.BannerTabHost
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val bannerList = ArrayList<BannerTabHost>()
    val firgementlist = ArrayList<Fragment>()
    var preItem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.currentItem = 0
        initBannerTabHost()
        initView()


    }

    fun initView() {
        firgementlist.add(HomeFragment())
        firgementlist.add(ClassfitionFragment())
        viewPager.setNoScroll(false)
        viewPager.adapter = ViewPagerFragmentAdapter(supportFragmentManager, firgementlist)
    }

    /**
     * 添加底部
     */
    private fun initBannerTabHost() {
        bannerList.add(tab_auslese)
        bannerList.add(tab_classfition)
        tab_auslese.setOnClickListener(this)
        tab_classfition.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v) {
                v.tab_auslese ->{
                    bannerList.get(preItem).setRbtLeftIconChecked(false)
                    viewPager.currentItem = 0
                    v.tab_auslese.setRbtLeftIconChecked(true)
                    preItem = 0
                }
                v.tab_classfition ->{
                    bannerList.get(preItem).setRbtLeftIconChecked(false)
                    viewPager.currentItem = 1
                    v.tab_classfition.setRbtLeftIconChecked(true)
                    preItem = 1
                }


            }
        }
    }
}
