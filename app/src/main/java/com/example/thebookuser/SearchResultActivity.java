package com.example.thebookuser;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.thebookuser.ui.home.ListViewAdapter;


public class SearchResultActivity extends AppCompatActivity

    implements AdapterView.OnItemClickListener

    {

        private static final String[] scenes = {
                "火花", "下町ロケット", "お金が貯まるのはどっち？", "羊と鋼の森",
                "ハリーポッターと賢者の石", "マスカレード・ホテル", "情報処理用語辞典"
        };
        private static final String[] author = {
                "又吉直樹", "池井戸潤", "菅井敏之", "宮下奈都", "J.K.ローリング", "東野圭吾", "福嶋宏訓"
        };
        private static final String[] isbn = {
                "4167907828", "4094088962", "4776208229", "4091398863", "4863892306", "4087452068",
                "4405025561"
        };

        private static final String[] lebel = {
                "文春文庫",
                "小学文庫", "アスコム", "文春文庫", "静山社文庫", "集英社文庫", "検定"
        };
        private static final String[] publisher = {
                "文藝春秋", "小学館", "文藝春秋", "静山社", "静山社", "集英社", "新星出版社"
        };
        private static final String[] money = {
                "660",
                "792", "1430", "748", "2,090", "836", "660"
        };
        private static final String[] genre = {
                "文学",
                "日本文学", "ビジネス", "文学", "SF,ファンタジー", "日本文学", "コンピュータ"
        };

        private static final String[] hangata = {
            "文庫判",
            "文庫判", "B6判", "文庫判", "46判", "文庫判", "B6判"
    };
        private static final String[] zaiko = {
                "13","11","5","3","6","7","在庫なし"

        };

        private static final int[] photos = {
                R.drawable.hibana,R.drawable.roketto,R.drawable.money,R.drawable.hituzimori,R.drawable.harrypotta,
                R.drawable.maskareido,R.drawable.jyouhou
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);


        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter=new ListViewAdapter(this.getApplicationContext(),R.layout.list,scenes,photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

        @Override
        public void onItemClick(AdapterView<?> parent, View v,
        int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SearchActivity.class);

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
        intent.putExtra("Text11",selectedText11);
        intent.putExtra("Text2", selectedText2);
        intent.putExtra("Text3", selectedText3);
        intent.putExtra("Text4", selectedText4);
        intent.putExtra("Text5", selectedText5);
        intent.putExtra("Text6", selectedText6);
        intent.putExtra("Text7", selectedText7);
        intent.putExtra("Text8", selectedText8);
        intent.putExtra("Photo", selectedPhoto);
        // SubActivityへ遷移
        startActivity(intent);
    }


}
