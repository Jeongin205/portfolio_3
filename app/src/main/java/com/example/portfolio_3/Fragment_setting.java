package com.example.portfolio_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class Fragment_setting extends Fragment {
    Button userset, bgset;
    TextView tv_email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        userset = v.findViewById(R.id.btn_userset);
        bgset = v.findViewById(R.id.btn_imgset);
        tv_email = v.findViewById(R.id.tv_email);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Name, email address, and profile photo Url
                String email = profile.getEmail();
                tv_email.setText(email);
            }
        }
        userset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UsersetActivity.class);
                startActivity(intent);
            }
        });
        bgset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImgsetActivity.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}