package com.example.lk.kotlinframework.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lk.kotlinframework.R;
import com.example.lk.kotlinframework.adapter.base.BaseAdapterIml;
import com.example.lk.kotlinframework.mvp.m.bean.HomeBean;

import java.util.List;

import kotlin.jvm.JvmStatic;

/**
 * Created by lk on 2018/6/11.
 */

public class DataRecycleUtils {

    @BindingAdapter("home")
    public static void sethomeadapter(RecyclerView recyclerView, List<HomeBean.IssueListBean.ItemListBean> data) {
        if (data == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        int layout = R.layout.classfition_item;
        BaseAdapterIml adapter = new BaseAdapterIml(recyclerView.getContext(), data, layout);
        recyclerView.setAdapter(adapter);
    }

}
