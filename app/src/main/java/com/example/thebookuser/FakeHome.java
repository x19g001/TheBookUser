package com.example.thebookuser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class FakeHome extends AppCompatActivity {

    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_home);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("ホーム");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //検索バーを追加(必須)
        getMenuInflater().inflate(R.menu.top_menu, menu);

        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        mSearchView =(SearchView) menuItem.getActionView();
        mSearchView.setOnQueryTextListener(this.onQueryTextListener);
        return true;
    }

    private SearchView.OnQueryTextListener onQueryTextListener=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String searchWord) {
            Intent intent=new Intent(FakeHome.this,SearchResultActivity.class);
            startActivity(intent);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
    //メニューやボタンの処理を実装する
    Intent intent;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //ログインボタンがタップされたとき
            case R.id.navigation_login:
                intent = new Intent(getApplication(), navigation_choiceaccount.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}