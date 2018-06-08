package com.example.lk.kotlinframework.mvp.p

/**
 * Created by lk on 2018/5/17.
 */
interface InterPersneter<V : ResultView<V>> {
     fun attach(view: V)
     fun delattach()
}
