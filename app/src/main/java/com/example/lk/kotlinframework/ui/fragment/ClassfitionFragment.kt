package com.example.lk.kotlinframework.mvp.v.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lk.kotlinframework.R
import com.example.lk.kotlinframework.adapter.HomeAdatper
import com.example.lk.kotlinframework.databinding.ClassfinitionHomeBinding
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import com.example.lk.kotlinframework.mvp.p.HomePresenter
import com.example.lk.kotlinframework.mvp.v.HomeContract
import com.example.lk.kotlinframework.utils.DataRecycleUtils
import kotlinx.android.synthetic.main.classfinition_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList
import java.util.regex.Pattern

/**
 * Created by lk on 2018/5/16.
 */
class ClassfitionFragment: Fragment, HomeContract.View {

    constructor() : super()

    var mIsRefresh: Boolean = false
    var mPresenter: HomePresenter? = null
    var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()
    var binding: ClassfinitionHomeBinding? = null
    var data: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.classfinition_home, container, false) as ClassfinitionHomeBinding?
        return binding?.root

    }

    override fun onStart() {
        super.onStart()
        mPresenter = activity?.let { HomePresenter(it, this) }
        mPresenter?.start()

    }

    override fun setData(bean: HomeBean) {
        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(bean?.nextPageUrl)
        data = m.replaceAll("").subSequence(1, m.replaceAll("").length - 1).toString()
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }

        }
        bean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }

        binding!!.data=mList
        DataRecycleUtils.sethomeadapter(rv,mList)
    }


}