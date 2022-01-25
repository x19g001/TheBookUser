package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebookuser.ui.home.ListViewAdapter;

public class ShopInfoActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    private static final String[] scenes = {
            "FJB書店"
    };
    private static final String[] jyusyo = {
            "〒273-0005千葉県船橋市本町7丁目12-16"
    };
    private static final String[] hour = {
            "営業時間 10:00~22:00"
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
        setContentView(R.layout.favoriteinfo);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);


        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, scenes, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SubshopInfoActivity.class);

        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        String selectedText3 = jyusyo[position];
        String selectedText2 = hour[position];
        String selectedText4 = tell[position];
        String selectedText5 = adress[position];

        int selectedPhoto = photos[position];

        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Text2", selectedText2);
        intent.putExtra("Text3", selectedText3);
        intent.putExtra("Text4", selectedText4);
        intent.putExtra("Text5", selectedText5);
        intent.putExtra("Photo", selectedPhoto);

        // SubActivityへ遷移
        startActivity(intent);
    }
}
