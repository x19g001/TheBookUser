package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

//import com.example.thebookuser.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class navigation_needlist extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_navigation_needlist);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

        ArrayList needlist = new ArrayList<>();


        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, needlist);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        final Button button1 = findViewById(R.id.next_button);
        final Button button2 = findViewById(R.id.backhome);

        //ボタンが押されたときの動作
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(navigation_needlist.this,navigation_needlist_add.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(navigation_needlist.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("欲しいものリスト");
    }



//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_needlist, container, false);
    }
}