package com.android.downlib.adapter;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.adapter
 * @ClassName: CommPopAdapter
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 10:26
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.downlib.R;

public class CustomPopAdapter extends BaseContentAdapter {
    /**
     * 布局加载器
     */
    private LayoutInflater mInflater;

    public CustomPopAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.custom_popup_list_item, null);
            viewHolder.mTitleTv = convertView.findViewById(R.id.tv_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTitleTv.setText(mData.get(i).toString());
        return convertView;
    }

    /**
     * vh
     */
    public class ViewHolder {
        /**
         * 筛选项文字tv
         */
        TextView mTitleTv;
    }

}
