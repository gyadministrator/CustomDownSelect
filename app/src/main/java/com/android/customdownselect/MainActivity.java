package com.android.customdownselect;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.downlib.adapter.CustomPopAdapter;
import com.android.downlib.entity.ClickContentEntity;
import com.android.downlib.entity.ContentEntity;
import com.android.downlib.entity.ContentItemEntity;
import com.android.downlib.view.CustomSelectTopView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomSelectTopView customSelectTopView;
    private List<ContentEntity> list = new ArrayList<>();
    private List<ContentItemEntity> province = new ArrayList<>();
    private List<ContentItemEntity> city = new ArrayList<>();
    private List<ContentItemEntity> town = new ArrayList<>();
    private List<ContentItemEntity> village = new ArrayList<>();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list.clear();
        province.clear();
        city.clear();
        town.clear();
        village.clear();
        province.add(new ContentItemEntity("", "北京市"));
        province.add(new ContentItemEntity("", "上海市"));
        province.add(new ContentItemEntity("", "天津市"));
        city.add(new ContentItemEntity("", "贵阳市"));
        city.add(new ContentItemEntity("", "成都市"));
        town.add(new ContentItemEntity("", "盘县"));
        town.add(new ContentItemEntity("", "织金县"));
        village.add(new ContentItemEntity("", "大方村"));
        village.add(new ContentItemEntity("", "珠东村"));
        list.add(new ContentEntity("0", "省份", province));
        list.add(new ContentEntity("1", "城市", city));
        list.add(new ContentEntity("2", "县", town));
        list.add(new ContentEntity("3", "村", village));

        list.add(new ContentEntity("0", "省份", province));
        list.add(new ContentEntity("1", "城市", city));
        list.add(new ContentEntity("2", "县", town));
        list.add(new ContentEntity("3", "村", village));
        //使用默认布局
        //customSelectTopView.setContent(list, null);
        //自定义内容adapter
        customSelectTopView.setContent(list, new CustomPopAdapter(this), new CustomSelectTopView.OnItemClickListener() {
            @Override
            public void onClickItem(ClickContentEntity clickContentEntity) {
                Log.e(TAG, "initData: " + clickContentEntity.toString());
            }
        });
    }

    private void initView() {
        customSelectTopView = findViewById(R.id.customSelectTopView);
    }
}
