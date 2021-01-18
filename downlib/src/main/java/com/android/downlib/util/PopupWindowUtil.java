package com.android.downlib.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;

import com.android.downlib.view.CommonFilterPop;

import java.util.List;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.util
 * @ClassName: PopupWindowUtil
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 10:32
 */
public class PopupWindowUtil {
    /**
     * 筛选pop
     */
    private CommonFilterPop mPopupWindow;
    private Activity mActivity;

    /**
     * 列表选择popupWindow
     *
     * @param parentView        父View
     * @param itemTexts         列表项文本集合
     * @param itemClickListener 列表项点击事件
     */
    public void showFilterPopupWindow(Activity activity, View parentView,
                                      List<String> itemTexts,
                                      AdapterView.OnItemClickListener itemClickListener) {
        mPopupWindow = null;
        mActivity = activity;
        showFilterPopupWindow(parentView, itemTexts, itemClickListener, 0);
    }

    /**
     * 列表选择popupWindow
     *
     * @param parentView        父View
     * @param adapter           adapter
     * @param itemClickListener 列表项点击事件
     */
    public void showFilterPopupWindow(Activity activity, View parentView,
                                      BaseAdapter adapter,
                                      AdapterView.OnItemClickListener itemClickListener) {
        mPopupWindow = null;
        mActivity = activity;
        showFilterPopupWindow(parentView, adapter, itemClickListener, 0);
    }

    /**
     * 列表选择popupWindow
     *
     * @param parentView        父View
     * @param adapter           adapter
     * @param itemClickListener 列表项点击事件
     * @param alpha             背景透明度
     */
    private void showFilterPopupWindow(View parentView,
                                       BaseAdapter adapter,
                                       AdapterView.OnItemClickListener itemClickListener, float alpha) {

        // 判断当前是否显示
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
        mPopupWindow = new CommonFilterPop(mActivity, adapter);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 当pop消失的时候,重置背景色透明度
                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
                lp.alpha = 1.0f;
                mActivity.getWindow().setAttributes(lp);
                mActivity = null;
            }
        });
        // 绑定筛选点击事件
        mPopupWindow.setOnItemSelectedListener(itemClickListener);
        // 如果透明度设置为0的话,则默认设置为0.6f
        if (0 == alpha) {
            alpha = 0.6f;
        }
        // 设置背景透明度
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = alpha;
        mActivity.getWindow().setAttributes(lp);
        // 显示pop
        mPopupWindow.showAsDropDown(parentView);
    }

    /**
     * 列表选择popupWindow
     *
     * @param parentView        父View
     * @param itemTexts         列表项文本集合
     * @param itemClickListener 列表项点击事件
     * @param alpha             背景透明度
     */
    private void showFilterPopupWindow(View parentView,
                                       List<String> itemTexts,
                                       AdapterView.OnItemClickListener itemClickListener, float alpha) {

        // 判断当前是否显示
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
        mPopupWindow = new CommonFilterPop(mActivity, itemTexts);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 当pop消失的时候,重置背景色透明度
                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
                lp.alpha = 1.0f;
                mActivity.getWindow().setAttributes(lp);
                mActivity = null;
            }
        });
        // 绑定筛选点击事件
        mPopupWindow.setOnItemSelectedListener(itemClickListener);
        // 如果透明度设置为0的话,则默认设置为0.6f
        if (0 == alpha) {
            alpha = 0.6f;
        }
        // 设置背景透明度
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = alpha;
        mActivity.getWindow().setAttributes(lp);
        // 显示pop
        mPopupWindow.showAsDropDown(parentView);
    }

    /**
     * 隐藏pop
     */
    public void hidePopListView() {
        // 判断当前是否显示,如果显示则dismiss
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
        }
    }
}
