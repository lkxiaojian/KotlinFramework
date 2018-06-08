package com.example.lk.kotlinframework.utils

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.lk.kotlinframework.R
import com.example.lk.kotlinframework.adapter.base.BaseAdapterIml
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by lk on 2018/6/8.
 */


    @BindingAdapter("home")
    fun sethomeadapter(recyclerView: RecyclerView, data: ArrayList<*>) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        val layout = R.layout.classfition_item
        val adapter = BaseAdapterIml(recyclerView.context, data , layout)
        recyclerView.adapter = adapter
    }

