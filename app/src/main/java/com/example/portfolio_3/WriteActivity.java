package com.example.portfolio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends AppCompatActivity {
    Button back;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/M/d");
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        textView = findViewById(R.id.tv_date);
        Date date = new Date();
        String time = mFormat.format(date);
        textView.setText(time);
        back = findViewById(R.id.btn_wback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}