package com.example.portfolio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends AppCompatActivity {
    Button back, send;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/M/d");
    private SimpleDateFormat mformat = new SimpleDateFormat("yyyyMd");
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    TextView textView;
    EditText diary;
    Date date = new Date();
    String time = mFormat.format(date);
    String a = mformat.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        textView = findViewById(R.id.tv_date);


        textView.setText(time);
        back = findViewById(R.id.btn_wback);
        send = findViewById(R.id.btn_send);
        diary = findViewById(R.id.et_diary);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddaylist(diary.getText().toString(), time);
                Intent intent = new Intent(WriteActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void adddaylist(String diary, String day) {
        dayList dayList = new dayList(diary, day);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid();
        databaseReference.child(Uid).child(a).setValue(dayList);
    }
}