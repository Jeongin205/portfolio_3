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
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MM/dd");
    private SimpleDateFormat mformat = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat month = new SimpleDateFormat("MM");
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    String month1="01";
    String day1="000000";
    int total_month=1;
    int total=0;
    TextView textView;
    EditText diary;
    Date date = new Date();
    String time = mFormat.format(date);
    String a = mformat.format(date);
    String month2 = month.format(date);
    String day2 = mformat.format(date);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        textView = findViewById(R.id.tv_date);

        if(!month1.equals(month2)){
            total_month=1;
            month1=month2;
        }
        else {
            total_month+=1;
        }
        if(!day1.equals(day2)){
            total+=1;
            day1=day2;
        }

        textView.setText(time);
        back = findViewById(R.id.btn_wback);
        send = findViewById(R.id.btn_send);
        diary = findViewById(R.id.et_diary);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddaylist(diary.getText().toString(), time);
                Toast.makeText(WriteActivity.this, "입력성공!", Toast.LENGTH_SHORT).show();
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