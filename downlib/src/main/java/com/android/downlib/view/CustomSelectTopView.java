package com.android.downlib.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.android.downlib.R;
import com.android.downlib.adapter.BaseContentAdapter;
import com.android.downlib.entity.ContentEntity;
import com.android.downlib.util.PopupWindowUtil;

import java.util.List;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.view
 * @ClassName: CustomSelectTopView
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 9:43
 */
public class CustomSelectTopView extends HorizontalScrollView {
    private List<ContentEntity> list;
    private Context mContext;
    private PopupWindowUtil popupWindowUtil;
    private BaseContentAdapter adapter;

    public CustomSelectTopView(Context context) {
        this(context, null);
    }

    public CustomSelectTopView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSelectTopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void setContent(List<ContentEntity> list, BaseContentAdapter adapter) {
        this.list = list;
        this.adapter = adapter;
        init();
    }

    private void init() {
        removeAllViews();
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (list != null && list.size() > 0) {
            for (final ContentEntity contentEntity : list) {
                if (contentEntity != null) {
                    String title = contentEntity.getTitle();
                    @SuppressLint("InflateParams") final View item = LayoutInflater.from(mContext).inflate(R.layout.custom_top_select, null);
                    int h = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
                    if (list.size() < 5) {
                        item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, h, 1));
                    } else {
                        item.setLayoutParams(new LinearLayout.LayoutParams(2 * h, h));
                    }
                    final CheckBox cbItem = item.findViewById(R.id.cb_item);
                    cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            //setStatus(item);
                            popupWindowUtil = new PopupWindowUtil();
                            if (adapter == null) {
                                popupWindowUtil.showFilterPopupWindow((Activity) mContext, item, contentEntity.getContent(), new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        cbItem.setText(contentEntity.getContent().get(position));
                                        popupWindowUtil.hidePopListView();
                                    }
                                });
                            } else {
                                adapter.setData(contentEntity.getContent());
                                popupWindowUtil.showFilterPopupWindow((Activity) mContext, item, adapter, new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        cbItem.setText(contentEntity.getContent().get(position));
                                        popupWindowUtil.hidePopListView();
                                    }
                                });
                            }
                        }
                    });
                    cbItem.setHint(title);
                    ViewGroup viewGroup = (ViewGroup) item.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(item);
                    }
                    linearLayout.addView(item);
                }
            }
        }
        ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(linearLayout);
        }
        addView(linearLayout);
    }

    private void setStatus(View item) {
        if (item != null) {
            CheckBox cbItem = item.findViewById(R.id.cb_item);
            cbItem.setChecked(true);
        }
        int childCount = getChildCount();
        if (childCount != 0) {
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                CheckBox cbItem = child.findViewById(R.id.cb_item);
                cbItem.setChecked(false);
            }
        }
    }
}
