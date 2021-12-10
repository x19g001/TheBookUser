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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navigation_needlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navigation_needlist extends AppCompatActivity {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public navigation_needlist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navigation_needlist.
     */
    // TODO: Rename and change types and number of parameters
    public static navigation_needlist newInstance(String param1, String param2) {
        navigation_needlist fragment = new navigation_needlist();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

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

        //ボタンが押されたときの動作
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(navigation_needlist.this,navigation_needlist_add.class);
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