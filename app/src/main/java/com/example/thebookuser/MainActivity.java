package com.example.thebookuser;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.thebookuser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_favorite, R.id.navigation_location).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


         Button homenext_button = findViewById(R.id.home_button);


        //アクションバーを無理やり非表示
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }

        //ボタンが押されたときの動作
        homenext_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,navigation_needlist.class);
                startActivity(intent);
            }
        });




    }






    //メニューやボタンを表示させる
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //検索バーを追加(必須)
        getMenuInflater().inflate(R.menu.top_menu, menu);

        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        mSearchView =(SearchView) menuItem.getActionView();
        mSearchView.setOnQueryTextListener(this.onQueryTextListener);
        return true;
    }

    //サーチバーがタップされたとき
    private SearchView.OnQueryTextListener onQueryTextListener=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String searchWord) {
            Intent intent=new Intent(MainActivity.this,SearchResultActivity.class);
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