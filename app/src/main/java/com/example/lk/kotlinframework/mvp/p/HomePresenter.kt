package com.example.lk.kotlinframework.mvp.p

import android.content.Context
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import com.example.lk.kotlinframework.mvp.m.moudle.HomeModel
import com.example.lk.kotlinframework.mvp.v.HomeContract
import com.example.lk.kotlinframework.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by lk on 2018/6/8.
 */
class HomePresenter(context: Context, view : HomeContract.View) : HomeContract.Presenter{
    var mContext : Context? = null
    var mView : HomeContract.View? = null
    val mModel : HomeModel by lazy {
        HomeModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,true,"0") }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }
    fun moreData(data: String?){
        val observable : Observable<HomeBean>? = mContext?.let { mModel.loadData(it,false,data) }
        observable?.applySchedulers()?.subscribe { homeBean : HomeBean ->
            mView?.setData(homeBean)
        }
    }


}
