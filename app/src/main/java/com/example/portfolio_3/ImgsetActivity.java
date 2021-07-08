package com.example.portfolio_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.graphics.Color.GREEN;

public class ImgsetActivity extends AppCompatActivity {
    Button back;
    ImageButton bg1, bg2, bg3, bg4, bg5, bg6;
    private FragmentManager manager;
    private Fragment_home fragment_home;
    private Fragment_memo fragment_memo;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgset);
        manager = getSupportFragmentManager();
        fragment_home = new Fragment_home();
        fragment_memo = new Fragment_memo();
        transaction = manager.beginTransaction();

        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        bg4 = findViewById(R.id.bg4);
        bg5 = findViewById(R.id.bg5);
        bg6 = findViewById(R.id.bg6);

        bg1.setOnClickListener(mListener);
        bg2.setOnClickListener(mListener);
        bg3.setOnClickListener(mListener);
        bg4.setOnClickListener(mListener);
        bg5.setOnClickListener(mListener);
        bg6.setOnClickListener(mListener);



        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImgsetActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    ImageButton.OnClickListener mListener = new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            transaction = manager.beginTransaction();
            switch (v.getId()){
                case R.id.bg1:
                    break;
                case R.id.bg2:
                    break;
                case R.id.bg3:break;
                case R.id.bg4:break;
                case R.id.bg5:break;
                case R.id.bg6:break;

            }
        }
    };
}