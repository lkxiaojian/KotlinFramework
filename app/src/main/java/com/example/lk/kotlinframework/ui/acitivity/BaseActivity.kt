package com.example.lk.kotlinframework.ui.acitivity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.lk.kotlinframework.mvp.p.AbsPresenter
import com.example.lk.kotlinframework.mvp.p.ResultView

/**
 * Created by lk on 2018/5/17.
 */
abstract class BaseActivity<V : ResultView<V>, P : AbsPresenter<V>> : AppCompatActivity(), ResultView<V> {
    internal var presenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (presenter == null) {
            presenter = bindPresenter()
        }
        presenter!!.attach(bindView())
    }

    internal abstract fun bindPresenter(): P
    internal abstract fun bindView(): V
    override fun onDestroy() {
        super.onDestroy()
        presenter!!.delattach()
    }
}