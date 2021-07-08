package com.example.portfolio_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.common.api.internal.BackgroundDetector;

import java.util.zip.Inflater;

import static android.graphics.Color.GREEN;

public class ImgsetActivity extends AppCompatActivity {
    Button back;
    ImageButton bg1, bg2, bg3, bg4, bg5, bg6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgset);

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
            switch (v.getId()){
                case R.id.bg1:
                    Intent intent1 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent1.putExtra("number", "1");
                    startActivity(intent1);
                    break;
                case R.id.bg2:
                    Intent intent2 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent2.putExtra("number", "2");
                    startActivity(intent2);
                    break;
                case R.id.bg3:
                    Intent intent3 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent3.putExtra("number", "3");
                    startActivity(intent3);
                    break;
                case R.id.bg4:
                    Intent intent4 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent4.putExtra("number", "4");
                    startActivity(intent4);
                    break;
                case R.id.bg5:
                    Intent intent5 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent5.putExtra("number", "5");
                    startActivity(intent5);
                    break;
                case R.id.bg6:
                    Intent intent6 = new Intent(ImgsetActivity.this, MainActivity2.class);
                    intent6.putExtra("number", "6");
                    startActivity(intent6);
                    break;

            }
        }
    };
}