package com.example.lk.kotlinframework.mvp.v

import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import com.example.lk.kotlinframework.mvp.p.base.BasePresenter
import com.example.lk.kotlinframework.mvp.v.base.BaseView

/**
 * Created by lk on 2018/6/8.
 */
interface HomeContract{
    interface View : BaseView<Presenter> {
        fun setData(bean : HomeBean)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }
}