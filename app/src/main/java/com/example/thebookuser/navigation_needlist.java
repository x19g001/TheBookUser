package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//import com.example.thebookuser.databinding.ActivityMainBinding;

import com.example.thebookuser.ui.home.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class navigation_needlist extends AppCompatActivity {

    private static final String[] scenes = {
            "火花", "下町ロケット", "お金が貯まるのはどっち？", "羊と鋼の森",
            "ハリーポッターと賢者の石", "マスカレード・ホテル", "情報処理用語辞典"
    };

    private static final int[] photos = {
            R.drawable.hibana,R.drawable.roketto,R.drawable.money,R.drawable.hituzimori,R.drawable.harrypotta,
            R.drawable.maskareido,R.drawable.jyouhou
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_navigation_needlist);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);


        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter=new ListViewAdapter(this.getApplicationContext(),R.layout.list,scenes,photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this::onItemClick);

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


    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SearchActivity.class);

        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        int selectedPhoto = photos[position];


        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        // SubActivityへ遷移
        startActivity(intent);
    }



//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_needlist, container, false);
    }
}