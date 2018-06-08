package com.example.lk.kotlinframework.mvp.v.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import com.example.lk.kotlinframework.R
import kotlinx.android.synthetic.main.custom_radio_text_bt.view.*


/**
 * 地步自定义view
 */
class BannerTabHost : RelativeLayout {
    constructor(context: Context) : super(context) {
        initView(context)
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context)
        initAttr(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun initAttr(context: Context, attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.BannerTabHost)
        val mIcon = array.getResourceId(R.styleable.BannerTabHost_LeftIcon, R.drawable.select_left_icon_selector)
        val mText = array.getString(R.styleable.BannerTabHost_TabText)
        val mState = array.getBoolean(R.styleable.BannerTabHost_CheckState, false)

        rbt_leftIcon.setCompoundDrawablesRelativeWithIntrinsicBounds(0, mIcon, 0, 0)
        rbt_leftIcon.isChecked = mState
        rbt_leftIcon.text = mText
        rbt_leftIcon.textSize = 11f
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
        initAttr(context, attrs)
    }

    /**
     * @param context
     */
    private fun initView(context: Context) {
        View.inflate(context, R.layout.custom_radio_text_bt, this)
        bt_message.visibility = View.GONE

    }

    /**
     * @param isVisibility
     */
    fun setBtMessageState(isVisibility: Boolean) {
        if (isVisibility) {
            bt_message.visibility = View.VISIBLE
        }
    }

    //public void setRbtLeftIcon(int )

    /**
     * @param messageText
     */
    fun setBtMessageText(messageText: String) {
        bt_message.text = messageText
    }

    fun setRbtLeftIconChecked(isCheck: Boolean) {
        rbt_leftIcon.isChecked = isCheck
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return super.onTouchEvent(event)
    }
}
