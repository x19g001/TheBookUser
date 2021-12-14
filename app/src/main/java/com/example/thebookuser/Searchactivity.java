//package com.example.thebookuser;
//
//import android.app.AppComponentFactory;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
//
//import com.example.thebookuser.R;
//
//import java.util.Locale;
//
//public class Searchactivity extends AppCompatActivity {
//    private static final String[] booknames = { "火花","下町ロケット","お金が貯まるのはどっち？","羊と鋼の森",
//            "ハリーポッターと賢者の石","マスカレード・ホテル","情報処理用語辞典","イチローの育て方","伝わっているかな？","マスカレード・ナイト"};
//
//    // drawableに画像を入れる、R.id.xxx はint型
//    private static final int[] photos={
//            R.drawable.hibana,R.drawable.roketto,R.drawable.money,R.drawable.hituzimori,R.drawable.harrypotta,
//            R.drawable.maskareido,R.drawable.jyouhou,R.drawable.itiro,R.drawable.tutawa,R.drawable.masakanight
//    };
//    private static final String[] isbn={"4167907828","4094088962","4776208229","4091398863","4863892306","4087452068",
//            "4405025561","4331514573","4883353040","4087441529"};
//    private static final String[] tyosaku={"又吉直樹","池井戸潤","宮下奈都","J.K.ローリング","東野圭吾","福嶋宏訓","河村健一郎","小西利行","東野圭吾"};
//
//    private ListView list;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.menu.top_menu);
//
//
//        // ISBN表示
//                String[] emails = new String[booknames.length];
//
//        // nameからメルアド作成
//        for(int i=0; i< booknames.length ;i++ ){
//
//        emails[i] = String.format(Locale.JAPAN, "%s@mail.co.jp",booknames[i]);
//        }
//        // ListViewのインスタンスを生成
//        ListView listView = findViewById(R.id.list_view);
//
//        // BaseAdapter を継承したadapterのインスタンスを生成
//        // レイアウトファイル list_items.xml を activity_main.xml に inflate するためにadapterに引数として渡す
//        BaseAdapter adapter=new adapter(this.getApplicationContext(),R.layout.list_items,booknames,isbn,photos);
//
//         //ListViewにadapterをセット
//        listView.setAdapter(adapter);
//
//       SearchView search = (SearchView) findViewById(R.id.searchView1);
//        list = (ListView) findViewById(R.id.list_view);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, array_adapter_data);
//        list.setAdapter(adapter);
//        list.setTextFilterEnabled(true);
//
//        // SearchViewの初期表示状態を設定
//        search.setIconifiedByDefault(false);
//
//
//        // SearchViewのSubmitボタンを使用不可にする
//        search.setSubmitButtonEnabled(true);
//
//        // SearchViewに何も入力していない時のテキストを設定
//        search.setQueryHint("書籍名・著者名を入力");
//    }
//}
