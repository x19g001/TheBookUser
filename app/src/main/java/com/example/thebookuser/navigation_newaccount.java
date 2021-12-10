package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navigation_newaccount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navigation_newaccount extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public navigation_newaccount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navigation_newaccount.
     */
    // TODO: Rename and change types and number of parameters
    public static navigation_newaccount newInstance(String param1, String param2) {
        navigation_newaccount fragment = new navigation_newaccount();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        setContentView(R.layout.activity_new_account);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("新規アカウント登録");

        TextInputEditText password = (TextInputEditText)findViewById(R.id.re_password);

        CheckBox passwordVisibilityCheckBox = (CheckBox) findViewById(R.id.password_checkBox);

        final Button next_mail_send_button = findViewById(R.id.next_mail_send);

        //アカウント新規登録ボタンが押されたときの動作
        next_mail_send_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(NewAccount.this, SendMail.class);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_newaccount, container, false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }
}