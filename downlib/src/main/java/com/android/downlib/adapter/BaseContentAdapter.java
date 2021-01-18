package com.android.downlib.adapter;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.adapter
 * @ClassName: BaseContentAdapter
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 14:34
 */
public abstract class BaseContentAdapter<T> extends BaseAdapter {
    protected List<T> mData;

    public void setData(List<T> mData) {
        this.mData = mData;
    }
}
