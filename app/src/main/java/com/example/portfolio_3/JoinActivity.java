package com.example.portfolio_3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class JoinActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button back;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        back = findViewById(R.id.btn_back);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btn_register).setOnClickListener(onClickListener);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.btn_register:
                    sighUp();
                    break;
            }
        }
    };

    private void sighUp() {
        String email = ((EditText)findViewById(R.id.et_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.et_pw)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.et_pw_check)).getText().toString();

        if(email.length()>0&&password.length()>0&&passwordCheck.length()>0){
            if(password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(JoinActivity.this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            if(task.getException().toString() != null){
                                Toast.makeText(JoinActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else{
                Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(JoinActivity.this, "이메일과 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
        }
    }
}