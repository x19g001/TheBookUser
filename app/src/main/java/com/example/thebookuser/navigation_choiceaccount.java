package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navigation_choiceaccount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navigation_choiceaccount extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public navigation_choiceaccount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navigation_choiceaccount.
     */
    // TODO: Rename and change types and number of parameters
    public static navigation_choiceaccount newInstance(String param1, String param2) {
        navigation_choiceaccount fragment = new navigation_choiceaccount();
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

        setContentView(R.layout.activity_choice_account);

        final Button new_account_button = findViewById(R.id.new_a_button);
        final Button next_login_button = findViewById(R.id.next_log_button);

        //アカウント新規登録ボタンが押されたときの動作
        new_account_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(ChoiceAccount.this, NewAccount.class);
                startActivity(intent);
            }
        });

        //ログインボタンが押されたときの動作
        next_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoiceAccount.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("ログイン画面");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_choiceaccount, container, false);
    }
}