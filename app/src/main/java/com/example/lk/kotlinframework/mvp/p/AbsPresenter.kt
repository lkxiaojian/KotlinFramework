package com.example.lk.kotlinframework.mvp.p

/**
 * Created by lk on 2018/5/17.
 */
abstract class AbsPresenter<V : ResultView<V>> : InterPersneter<V> {
    var view: V? = null
        private set

    override fun attach(view: V) {
        this.view = view
    }

    override fun delattach() {
        this.view = null
    }
}
