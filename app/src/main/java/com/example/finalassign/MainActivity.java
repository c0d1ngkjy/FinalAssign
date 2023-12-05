package com.example.finalassign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    CalcFragment calcFragment;
    DrawFragment drawFragment;
    GalleryFragment galleryFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int itemId = item.getItemId();
                if (itemId == R.id.tab1) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout, new HomeFragment())
                            .commit();
                    return true;
                } else if (itemId == R.id.tab2) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout, new CalcFragment())
                            .commit();
                    return true;
                } else if (itemId == R.id.tab3) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout, new DrawFragment())
                            .commit();
                    return true;
                } else if (itemId == R.id.tab4) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout, new GalleryFragment())
                            .commit();
                    return true;
                }
                return false;
            }
        });
    }

    private void init(){
        //fragment 객체 생성
        homeFragment = new HomeFragment();
        calcFragment = new CalcFragment();
        drawFragment = new DrawFragment();
        galleryFragment = new GalleryFragment();

        //main.xml상의 bottomNavigationView 연결
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //제일 처음 띄어줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,homeFragment).commitAllowingStateLoss();

    }
}