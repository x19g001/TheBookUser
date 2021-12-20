package com.example.thebookuser;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbook);

        Intent intent = getIntent();
        // MainActivityからintentで受け取ったものを取り出す
        String selectedText = intent.getStringExtra("Text");
        String selectedText2 = intent.getStringExtra("Text2");
        String selectedText3 = intent.getStringExtra("Text3");
        String selectedText4 = intent.getStringExtra("Text4");
        String selectedText5 = intent.getStringExtra("Text5");
        String selectedText6 = intent.getStringExtra("Text6");
        String selectedText7 = intent.getStringExtra("Text7");
        String selectedText8 = intent.getStringExtra("Text8");



        TextView textView = findViewById(R.id.selected_text);
        textView.setText(selectedText);

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

        TextView textView6 = findViewById(R.id.selected_text6);
        SpannableString spanStr6 = new SpannableString(selectedText6);
        spanStr6.setSpan(new UnderlineSpan(), 0, selectedText6.length(), 0);
        textView6.setText(spanStr6);

        TextView textView7 = findViewById(R.id.selected_text7);
        SpannableString spanStr7 = new SpannableString(selectedText7);
        spanStr7.setSpan(new UnderlineSpan(), 0, selectedText7.length(), 0);
        textView7.setText(spanStr7);

        TextView textView8 = findViewById(R.id.selected_text8);
        SpannableString spanStr8 = new SpannableString(selectedText8);
        spanStr8.setSpan(new UnderlineSpan(), 0, selectedText8.length(), 0);
        textView8.setText(spanStr8);


    }
}
