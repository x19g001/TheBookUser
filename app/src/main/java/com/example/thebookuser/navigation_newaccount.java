package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;


public class navigation_newaccount extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

        setContentView(R.layout.fragment_navigation_newaccount);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("新規アカウント登録");

        TextInputEditText password = (TextInputEditText)findViewById(R.id.re_password);

        CheckBox passwordVisibilityCheckBox = (CheckBox) findViewById(R.id.password_checkBox);

        final Button next_mail_send_button = findViewById(R.id.next_mail_send);

        //次へが押されたときの動作
        next_mail_send_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplication(), navigation_sendmail.class);
                startActivity(intent);
            }
        });

        // パスワード切り替えチェックボックス
        passwordVisibilityCheckBox.setOnClickListener((View v) -> {

            // パスワードのカーソル位置保存
            int cursorPos = password.getSelectionStart();

            boolean checked = passwordVisibilityCheckBox.isChecked();
            if (checked) {
                // パスワード可視化
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                // カーソル位置セット
                password.setSelection(cursorPos);
            } else {
                // パスワード不可視化
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                password.setSelection(cursorPos);
            }
        });
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_navigation_newaccount, container, false);
//    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }
}