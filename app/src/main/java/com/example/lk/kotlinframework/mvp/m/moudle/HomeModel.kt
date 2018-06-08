package com.example.lk.kotlinframework.mvp.m.moudle

import android.content.Context
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean
import com.example.lk.kotlinframework.network.ApiService
import com.example.lk.kotlinframework.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by lk on 2018/6/8.
 */
class HomeModel{
    fun loadData(context: Context, isFirst: Boolean, data: String?): Observable<HomeBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService  = retrofitClient.create(ApiService::class.java)
        when(isFirst) {
            true -> return apiService?.getHomeData()

            false -> return apiService?.getHomeMoreData(data.toString(), "2")
        }
    }
}