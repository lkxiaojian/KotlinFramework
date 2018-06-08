package com.example.lk.kotlinframework.mvp.p

/**
 * Created by lk on 2018/5/17.
 */
interface ResultView<T> {
    fun Result(result: T, message: String)

    fun Error(result: T)

    fun Refresh(refresh: T, message: String)
}