# CustomDownSelect

废话不多说，先上图！！！！！：

![image](https://github.com/gyadministrator/CustomDownSelect/blob/master/images/spot.png)

怎样使用?

工程的Gradle引入方式：

    repositories {
            google()
            jcenter()
            mavenCentral()
        }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
            mavenCentral()
        }
    }

  dependencies {
		implementation 'com.github.gyadministrator:CustomDownSelect:1.2'
	}
  
  Maven引入方式:

第一步，添加到build文件中


  <repositories>

	<repository>

	    <id>jitpack.io</id>

	    <url>https://jitpack.io</url>

    </repository>

  </repositories>

在activity使用，非常简单。
  
在xml中添加这个view。
  
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical"
     tools:context=".MainActivity">

     <com.android.downlib.view.CustomSelectTopView
         android:id="@+id/customSelectTopView"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:orientation="horizontal" />

 </LinearLayout>

 activity中使用
  
 package com.android.customdownselect;

 import android.os.Bundle;

 import androidx.appcompat.app.AppCompatActivity;

 import com.android.downlib.adapter.CustomPopAdapter;
 import com.android.downlib.entity.ContentEntity;
 import com.android.downlib.view.CustomSelectTopView;

 import java.util.ArrayList;
 import java.util.List;

 public class MainActivity extends AppCompatActivity {
     private CustomSelectTopView customSelectTopView;
     private List<ContentEntity> list = new ArrayList<>();
     private List<String> province = new ArrayList<>();
     private List<String> city = new ArrayList<>();
     private List<String> town = new ArrayList<>();
     private List<String> village = new ArrayList<>();

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
         province.add("北京市");
         province.add("上海市");
         province.add("天津市");
         city.add("贵阳市");
         city.add("成都市");
         town.add("盘县");
         town.add("织金县");
         village.add("大方村");
         village.add("珠东村");
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
         customSelectTopView.setContent(list, new CustomPopAdapter(this));
     }

     private void initView() {
         customSelectTopView = findViewById(R.id.customSelectTopView);
     }
 }

注意：支持横向滑动。


