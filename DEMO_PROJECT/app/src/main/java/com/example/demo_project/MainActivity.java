package com.example.demo_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


import com.example.demo_project.activity.LoginActivity;
import com.example.demo_project.fragment.FragmentAccount;
import com.example.demo_project.fragment.FragmentAddNewWordForm;
import com.example.demo_project.fragment.FragmentDetailWord;
import com.example.demo_project.fragment.FragmentHome;
import com.example.demo_project.fragment.FragmentListArticle;
import com.example.demo_project.fragment.FragmentListWord;
import com.example.demo_project.fragment.FragmentListWordRemember;
import com.example.demo_project.fragment.FragmentListWordRemind;
import com.example.demo_project.fragment.FragmentSearch;
import com.example.demo_project.fragment.FragmentSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{
    FrameLayout frameLayout;
    FloatingActionButton floatingActionButton;
    BottomNavigationView bottomNavigationView;
    public static FragmentHome fragmentHome;
    public static FragmentSearch fragmentSearch;
    public static FragmentAccount fragmentAccount;
    public static FragmentSetting fragmentSetting;
    public static FragmentAddNewWordForm fragmentAddNewWordForm;
    public static FragmentListWordRemember fragmentListWordRemember;
    public static FragmentListWordRemind fragmentListWordRemind;
    public static FragmentListWord fragmentListWord;
    public static FragmentDetailWord fragmentDetailWord;
    public static FragmentListArticle fragmentListArticle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // check login user
        SharedPreferences prefs = getSharedPreferences("ACCESS_TOKEN", MODE_PRIVATE);
        String token = prefs.getString("token", null);//"No name defined" is the default value.
        if (token == null || token.length() == 0) {
            // chuy???n trang login
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            this.startActivity(intent);
        }

        initView();
//        hideNavigation();
    }
    private void initView() {
        floatingActionButton = findViewById(R.id.btn_floating_add);

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.btn_navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(this);

        fragmentHome = new FragmentHome();
        fragmentSearch = new FragmentSearch();
        fragmentAccount = new FragmentAccount();
        fragmentSetting = new FragmentSetting();
        fragmentListWordRemember = new FragmentListWordRemember();
        fragmentListWordRemind = new FragmentListWordRemind();
        fragmentListWord = new FragmentListWord();
        fragmentAddNewWordForm = new FragmentAddNewWordForm();
        fragmentDetailWord = new FragmentDetailWord();
        fragmentListArticle = new FragmentListArticle();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragmentHome, FragmentHome.class.getName())
                .commit();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentAddNewWordForm, FragmentAddNewWordForm.class.getName())
                        .commit();
            }
        });
    }
//    public void hideNavigation(){
//        bottomNavigationView.addOnDestinationChangedListener { , destination,  ->
//            if(destination.id == R.id.full_screen_destination) {
//
//                bottomNavigationView.visibility = View.GONE
//            } else {
//
//                bottomNavigationView.visibility = View.VISIBLE
//            }
//        }
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentHome, FragmentHome.class.getName())
                        .commit();
                break;
            case R.id.menu_search:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentSearch, FragmentSearch.class.getName())
                        .commit();
                break;

            case R.id.menu_account:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentAccount, FragmentAccount.class.getName())
                        .commit();
                break;
            case R.id.menu_setting:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentSetting, FragmentSetting.class.getName())
                        .commit();
                break;
        }
        return true;
    }
}