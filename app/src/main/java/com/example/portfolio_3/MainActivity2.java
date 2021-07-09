package com.example.portfolio_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.portfolio_3.R.drawable.bg1;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RelativeLayout relativeLayout;
    String a=null;
    Intent mintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        relativeLayout = findViewById(R.id.mback);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        mintent= getIntent();
        String num = mintent.getStringExtra("number");


        if(num!=null){
            if (num.equals("1")){
                relativeLayout.setBackgroundResource(bg1);

            }
            if (num.equals("2")){
                relativeLayout.setBackgroundResource(R.drawable.bg2);

            }
            if (num.equals("3")){
                relativeLayout.setBackgroundResource(R.drawable.bg3);

            }
            if (num.equals("4")){
                relativeLayout.setBackgroundResource(R.drawable.bg4);

            }
            if (num.equals("5")){
                relativeLayout.setBackgroundResource(R.drawable.bg5);

            }
            if (num.equals("6")){
                relativeLayout.setBackgroundResource(R.drawable.bg6);

            }
        }
        else if(a != null) {
            if (a.equals("1")){
                relativeLayout.setBackgroundResource(bg1);
            }
            else if (a.equals("2")){
                relativeLayout.setBackgroundResource(R.drawable.bg2);
            }
            else if (a.equals("3")){
                relativeLayout.setBackgroundResource(R.drawable.bg3);
            }
            else if (a.equals("4")){
                relativeLayout.setBackgroundResource(R.drawable.bg4);
            }
            else if (a.equals("5")){
                relativeLayout.setBackgroundResource(R.drawable.bg5);
            }
            else if (a.equals("6")){
                relativeLayout.setBackgroundResource(R.drawable.bg6);
            }
        }



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
