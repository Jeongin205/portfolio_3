package com.example.portfolio_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottomNavi);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Fragment_home()).commit(); //FrameLayout에 fragment.xml 띄우기


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_home()).commit();
                        break;
                    case R.id.menu_memo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_memo()).commit();
                        break;
                    case R.id.menu_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_setting()).commit();
                        break;
                }
                return false;
            }

        });
    }
}
