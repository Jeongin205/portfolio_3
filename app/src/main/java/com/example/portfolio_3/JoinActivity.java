package com.example.portfolio_3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    Button back;
    private FirebaseAuth mAuth;
    //현재 로그인 된 유저 정보를 담을 변수
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();

        //이메일
        final EditText emailTxt = (EditText)findViewById(R.id.et_email);
        //이름
        final EditText nameTxt = (EditText)findViewById(R.id.et_user);
        //비밀번호
        final EditText pwTxt = (EditText)findViewById(R.id.et_pw);
        //버튼
        Button joinBtn = (Button)findViewById(R.id.btn_register);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //버튼이 눌렀을 때
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailTxt.getText().toString();
                String name = nameTxt.getText().toString();
                String pw = pwTxt.getText().toString();



                //가입 성공했을 때 -> 감사리스트 메인 페이지로 이동하기

                //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                //startActivityForResult(signInIntent, 100);Toast.makeText(AuthActivity.this,"btn",Toast.LENGTH_SHORT).show();
                //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                // startActivityForResult(signInIntent, 100);

                joinStart(email,name,pw);
            }
        });

    }
    //가입 함수
    public void joinStart(String email, final String name, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()) {
                            try {
                                throw task.getException();
                            } catch(FirebaseAuthWeakPasswordException e) {
                                Toast.makeText(JoinActivity.this,"비밀번호가 간단해요.." ,Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(JoinActivity.this,"email 형식에 맞지 않습니다." ,Toast.LENGTH_SHORT).show();
                            } catch(FirebaseAuthUserCollisionException e) {
                                Toast.makeText(JoinActivity.this,"이미존재하는 email 입니다." ,Toast.LENGTH_SHORT).show();
                            } catch(Exception e) {
                                Toast.makeText(JoinActivity.this,"다시 확인해주세요." ,Toast.LENGTH_SHORT).show();
                            }
                        }else{

                            currentUser = mAuth.getCurrentUser();

                            Toast.makeText(JoinActivity.this, "가입 성공 ",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                });

    }}
