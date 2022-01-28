package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubTShopInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshop_info_sub);

        Intent intent = getIntent();
        // MainActivityからintentで受け取ったものを取り出す
        String selectedText = intent.getStringExtra("Text");
        String selectedText11=intent.getStringExtra("Text11");
        String selectedText2 = intent.getStringExtra("Text2");
        String selectedText3 = intent.getStringExtra("Text3");
        String selectedText4 = intent.getStringExtra("Text4");
        String selectedText5 = intent.getStringExtra("Text5");




        int selectedPhoto = intent.getIntExtra("Photo", 0);
        ImageView imageView1 = findViewById(R.id.selected_photo);
        imageView1.setImageResource(selectedPhoto);

        TextView textView = findViewById(R.id.selected_text);
        textView.setText(selectedText);

        TextView textView11 = findViewById(R.id.selected_text11);
        SpannableString spanStr11 = new SpannableString(selectedText11);
        spanStr11.setSpan(new UnderlineSpan(), 0, selectedText11.length(), 0);
        textView11.setText(spanStr11);

        TextView textView2 = findViewById(R.id.selected_text2);
        SpannableString spanStr2 = new SpannableString(selectedText2);
        spanStr2.setSpan(new UnderlineSpan(), 0, selectedText2.length(), 0);
        textView2.setText(spanStr2);


        TextView textView3 = findViewById(R.id.selected_text3);
        SpannableString spanStr3 = new SpannableString(selectedText3);
        spanStr3.setSpan(new UnderlineSpan(), 0, selectedText3.length(), 0);
        textView3.setText(spanStr3);

        TextView textView4 = findViewById(R.id.selected_text4);
        SpannableString spanStr4 = new SpannableString(selectedText4);
        spanStr4.setSpan(new UnderlineSpan(), 0, selectedText4.length(), 0);
        textView4.setText(spanStr4);

        TextView textView5 = findViewById(R.id.selected_text5);
        SpannableString spanStr5 = new SpannableString(selectedText5);
        spanStr5.setSpan(new UnderlineSpan(), 0, selectedText5.length(), 0);
        textView5.setText(spanStr5);




    }
}