package com.example.lk.kotlinframework.mvp.v.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lk.kotlinframework.R

import com.example.lk.kotlinframework.adapter.HomeAdatper
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import com.example.lk.kotlinframework.mvp.p.HomePresenter
import com.example.lk.kotlinframework.mvp.v.HomeContract

import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList
import java.util.regex.Pattern


/**
 * Created by lk on 2018/5/16.
 */
class HomeFragment : Fragment, HomeContract.View, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        if (!mIsRefresh) {
            mIsRefresh = true
            mPresenter?.start()
        }
    }

    constructor() : super()

    val TAG = "tag"
    var mIsRefresh: Boolean = false
    var mPresenter: HomePresenter? = null
    var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()
    var mAdapter: HomeAdatper? = null
    var data: String? = null
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
        mAdapter?.notifyDataSetChanged()

    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        mPresenter = activity?.let { HomePresenter(it, this) }
        mPresenter?.start()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        mAdapter = activity?.let { HomeAdatper(it, mList) }
        recyclerView.adapter = mAdapter
        refreshLayout.setOnRefreshListener(this)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList.size - 1) {
                    if (data != null) {
                        mPresenter?.moreData(data)
                    }

                }
            }
        })


    }
}