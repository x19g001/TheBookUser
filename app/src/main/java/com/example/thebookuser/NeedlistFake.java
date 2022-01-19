package com.example.thebookuser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeedlistFake extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needlist_fake);

        String[] scenes = {
                "容疑者Xの献身", "火花", "下町ロケット", "お金が貯まるのはどっち？", "羊と鋼の森",
                "ハリーポッターと賢者の石", "マスカレード・ホテル", "情報処理用語辞典"
        };

        String[] author = {
                "東野圭吾", "又吉直樹", "池井戸潤", "菅井敏之", "宮下奈都", "J.K.ローリング", "東野圭吾", "福嶋宏訓"
        };


        // ListViewに表示するリスト項目をArrayListで準備する
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0; i<scenes.length; i++){
            Map<String, String> item = new HashMap<String, String>();
            item.put("Subject", scenes[i]);
            item.put("Comment", author[i]);
            data.add(item);
        }

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] { "Subject", "Comment"},
                new int[] { android.R.id.text1, android.R.id.text2});

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        final Button button1 = findViewById(R.id.next_button);
        final Button button2 = findViewById(R.id.backhome);

        //ボタンが押されたときの動作
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(NeedlistFake.this,navigation_needlist_add.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(NeedlistFake.this,MainActivity.class);
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




}