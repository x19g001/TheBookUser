package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thebookuser.login.LoginActivity;


public class navigation_choiceaccount extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_navigation_choiceaccount);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

         Button new_account_button = findViewById(R.id.new_a_button);
         Button next_login_button = findViewById(R.id.next_log_button);

        //アカウント新規登録ボタンが押されたときの動作
        new_account_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(), navigation_newaccount.class);
                startActivity(intent);
            }
        });

        //アカウントをお持ちの方はこちらが押されたときの動作
        next_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("ログイン画面");
    }

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_choiceaccount, container, false);
    }
}