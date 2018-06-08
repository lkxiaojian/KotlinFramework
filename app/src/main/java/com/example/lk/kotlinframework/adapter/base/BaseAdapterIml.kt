package com.example.lk.kotlinframework.adapter.base

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by lk on 2018/6/8.
 */
 class BaseAdapterIml<T>(var context: Context, var list:MutableList<T>,var layout: Int) :
        BaseDataRecycleAdapter<T>(context,list) {


    override val layoutId: Int
        get() = layout

}
