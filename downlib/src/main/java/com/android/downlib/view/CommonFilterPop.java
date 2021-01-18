package com.android.downlib.view;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.view
 * @ClassName: CommonFilterPop
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 10:25
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.android.downlib.R;
import com.android.downlib.adapter.CommPopAdapter;

import java.util.List;

public class CommonFilterPop<T> extends PopupWindow {
    /**
     * 布局填充器
     */
    private LayoutInflater mInflater;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 只显示String类型的数据
     */
    private List<T> mData;
    /**
     * pop整体View
     */
    private View popupView;
    /**
     * 选择条件的list
     */
    private ListView contentLv;
    /**
     * 筛选条件选择后的回调
     */
    AdapterView.OnItemClickListener itemClickListener;
    /**
     * 适配器
     */
    CommPopAdapter adapter;


    /**
     * 构造函数
     *
     * @param context context
     * @param mData   mData
     */
    @SuppressLint("InflateParams")
    public CommonFilterPop(Context context, List<T> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = mData;
        popupView = mInflater.inflate(
                R.layout.common_popup_list_dialog, null);
        //设置View
        this.setContentView(popupView);
        //设置弹出窗体的宽高
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //初始化控件
        initPopView();
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        //需要动画效果的话可以设置
        //this.setAnimationStyle(R.style.PopupWindowAnimation);
        this.update();
    }

    /**
     * 构造函数
     *
     * @param context context
     * @param adapter adapter
     */
    @SuppressLint("InflateParams")
    public CommonFilterPop(Context context, BaseAdapter adapter) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        popupView = mInflater.inflate(
                R.layout.common_popup_list_dialog, null);
        //设置View
        this.setContentView(popupView);
        //设置弹出窗体的宽高
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //初始化控件
        initPopView(adapter);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        //需要动画效果的话可以设置
        //this.setAnimationStyle(R.style.PopupWindowAnimation);
        this.update();
    }


    private void initPopView() {
        contentLv = popupView.findViewById(R.id.lv_pop);
        adapter = new CommPopAdapter(mContext);
        adapter.setData(mData);
        contentLv.setAdapter(adapter);
    }

    private void initPopView(BaseAdapter adapter) {
        contentLv = popupView.findViewById(R.id.lv_pop);
        contentLv.setAdapter(adapter);
    }


    /**
     * listview点击事件
     *
     * @param itemClickListener itemClickListener
     */
    public void setOnItemSelectedListener(AdapterView.OnItemClickListener itemClickListener) {
        if (null != itemClickListener && null != contentLv) {
            contentLv.setOnItemClickListener(itemClickListener);
        }
    }

}
