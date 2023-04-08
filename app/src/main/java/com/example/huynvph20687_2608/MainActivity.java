package com.example.huynvph20687_2608;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager2 viewpage;
    viewpagerfrg adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout=findViewById(R.id.tablauout);
        viewpage=findViewById(R.id.viewpage);
        adapter=new viewpagerfrg(this);
        viewpage.setAdapter(adapter);
        new TabLayoutMediator(tablayout, viewpage, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Danh Sách Nhân Sự");
                        break;
                    case 1:
                        tab.setText("Thêm Nhân sự");
                        break;
                }
            }
        }).attach();
    }
}