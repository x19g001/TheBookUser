package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebookuser.ui.home.ListViewAdapter;

public class SearchBactivity  extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String[] scenes = {
            "火花"
    };
    private static final int[] photos = {
            R.drawable.hibana
    };

    private static final String[] author = {
            "又吉直樹"
    };
    private static final String[] isbn = {
            "4167907828"
    };

    private static final String[] lebel = {
            "文春文庫",

    };
    private static final String[] publisher = {
            "文藝春秋"
    };
    private static final String[] money = {
            "660",

    };
    private static final String[] genre = {
            "文学",

    };

    private static final String[] hangata = {
            "文庫判",

    };

    private static final String[] zaiko = {
            "13",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchdf);
        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, scenes, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent(this.getApplicationContext(), Searchfactivity.class);
        // clickされたpositionのtextとphotoのID
        String selectedText = scenes[position];
        String selectedText11 = "在庫数:"+zaiko[position];
        String selectedText3 = "著者名:"+author[position];
        String selectedText2 = "ISBN:"+isbn[position];
        String selectedText4 = "レーベル:"+lebel[position];
        String selectedText5 = "出版社:"+publisher[position];
        String selectedText6 = "値段:"+money[position]+"円(税込)";
        String selectedText7 = "ジャンル:"+ genre[position];
        String selectedText8 = "判型:"+hangata[position];
        int selectedPhoto = photos[position];
        // インテントにセット
        intent.putExtra("Text", selectedText);
        intent.putExtra("Photo", selectedPhoto);
        intent.putExtra("Text11",selectedText11);
        intent.putExtra("Text2", selectedText2);
        intent.putExtra("Text3", selectedText3);
        intent.putExtra("Text4", selectedText4);
        intent.putExtra("Text5", selectedText5);
        intent.putExtra("Text6", selectedText6);
        intent.putExtra("Text7", selectedText7);
        intent.putExtra("Text8", selectedText8);
        // Activity をスイッチする
        startActivity(intent);
    }
}
