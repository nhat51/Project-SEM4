package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.LoginDto;
import com.example.demo_project.entity.LoginToken;
import com.example.demo_project.entity.UserResponse;
import com.example.demo_project.service.UserService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
//    Button btn_login;
//    EditText et_login_name, et_login_pass;
//    UserService userService;
//    LoginToken loginToken = null;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        int SDK_INT = android.os.Build.VERSION.SDK_INT;
//        if (SDK_INT > 8)
//        {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                    .permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//            //your codes here
//        }
//        initData();
//        initListener();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SharedPreferences sharedPref = getSharedPreferences("token", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("token", loginToken.getAccessToken());
//        editor.commit();
//        Log.d("token", sharedPref.getString("token", null));
//    }
//
//    private void initData() {
//        btn_login = findViewById(R.id.btn_login);
//        et_login_name = findViewById(R.id.et_login_name);
//        et_login_pass = findViewById(R.id.et_login_pass);
//    }
//    private void initListener(){
//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = et_login_name.getText().toString();
//                String password = et_login_pass.getText().toString();
//
//                LoginDto loginDto = new LoginDto();
//                loginDto.setUsername(username);
//                loginDto.setPassword(password);
//                if (userService == null){
//                    userService = RetrofitGenerator.createService(UserService.class);
//                }
//                try {
//                    Response<UserResponse> tokenResponse =  userService.login(loginDto).execute();
//                    if(tokenResponse.isSuccessful()){
//
//                        loginToken = tokenResponse.body().getBody();
//                        Log.d("Token",loginToken.getUsername());
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
Button btn_login;
    EditText et_login_name, et_login_pass;
    UserService userService;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
            settings = getApplicationContext().getSharedPreferences("token", MODE_PRIVATE);
            editor = settings.edit();
        }
        initData();
        initListener();
    }

    private void initData() {
        btn_login = findViewById(R.id.btn_login);
        et_login_name = findViewById(R.id.et_login_name);
        et_login_pass = findViewById(R.id.et_login_pass);
    }
    private void initListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_login_name.getText().toString();
                String password = et_login_pass.getText().toString();

                LoginDto loginDto = new LoginDto();
                loginDto.setUsername(username);
                loginDto.setPassword(password);
                if (userService == null){
                    userService = RetrofitGenerator.createService(UserService.class);
                }
                try {
                    Response<UserResponse> tokenResponse =  userService.login(loginDto).execute();
                    if(tokenResponse.isSuccessful()){

                        LoginToken loginToken = tokenResponse.body().getBody();
                        Log.d("aaaa", loginToken.toString());
                        token = loginToken.getAccess_token();
                        String refreshToken = loginToken.getRefresh_token();
                        Log.d("Token",loginToken.getUsername());
                        if (token != null) editor.putString("token", token);
                        if (refreshToken != null) editor.putString("refreshToken", refreshToken);
                        editor.commit();
                        Toast.makeText(LoginActivity.this, "Login success",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}