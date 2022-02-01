package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.BaseAdapter;

import android.widget.ListView;


import com.example.thebookuser.ui.home.ListViewAdapter2;


public class navigation_favorite extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] scenes = {
            "FJB書店"
    };
    private static final String[] yubin = {
            "〒273-0005"
    };
    private static final String[] jyusyo = {
            "千葉県船橋市本町7丁目12-16"

    };
    private static final String[] hour = {
            "営業時間:10:00~22:00"
    };

    private static final String[] tell = {
            "03-459-1932"
    };

    private static final String[] adress = {
            "fjb.net"

    };

    private static final int[] photos = {
            R.drawable.fjbmap
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshop_info);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view1);

        setSupportActionBar(findViewById(R.id.toolbar));

        getSupportActionBar().setTitle("お気に入り");

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter2(this.getApplicationContext(),
                R.layout.list2, scenes, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(this.getApplicationContext(), SubTShopInfoActivity.class);
        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        String selectedText11 = yubin[position];
        String selectedText2 = jyusyo[position];
        String selectedText3 = hour[position];
        String selectedText4 = "電話番号:" + tell[position];
        String selectedText5 = "メールアドレス:" + adress[position];
        int selectedPhoto = photos[position];

        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Text11", selectedText11);
        intent.putExtra("Text2", selectedText2);
        intent.putExtra("Text3", selectedText3);
        intent.putExtra("Text4", selectedText4);
        intent.putExtra("Text5", selectedText5);
        intent.putExtra("Photo", selectedPhoto);

        // SubActivityへ遷移
        startActivity(intent);
    }
}