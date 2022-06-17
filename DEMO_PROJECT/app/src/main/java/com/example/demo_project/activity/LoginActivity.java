package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.LoginDto;
import com.example.demo_project.entity.LoginToken;
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.entity.UserResponse;
import com.example.demo_project.service.UserService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_login_name, et_login_pass;
    TextView userNameAlertLogin, passwordAlertLogin, redirect_register;
    UserService userService;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }
        initData();
        // nếu có token rồi thì đưa sang trang khác.
        // Xử lý check token tại trang home (defautl phải là trang home), nếu chưa có token mới về đây.
        initListener();
        redirectRegister();
    }

    private void initData() {
        btn_login = findViewById(R.id.btn_login);
        et_login_name = findViewById(R.id.et_login_name);
        et_login_pass = findViewById(R.id.et_login_pass);
        redirect_register = findViewById(R.id.redirect_register);

        userNameAlertLogin = findViewById(R.id.UserNameAlertLogin);
        passwordAlertLogin = findViewById(R.id.PasswordAlertLogin);
    }

    private void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_login_name.getText().toString();
                String password = et_login_pass.getText().toString();

                LoginDto loginDto = new LoginDto();
                loginDto.setUsername(username);
                loginDto.setPassword(password);
                if (userService == null) {
                    userService = RetrofitGenerator.createService(UserService.class);
                }
                try {
                    Response<UserResponse> tokenResponse = userService.login(loginDto).execute();
                    if (tokenResponse.isSuccessful()) {
                        LoginToken loginToken = tokenResponse.body().getBody();
                        token = loginToken.getAccess_token();
                        String refreshToken = loginToken.getRefresh_token();
                        Log.d("Access Token nè",loginToken.getAccess_token());
                        SharedPreferences.Editor editor = getSharedPreferences("ACCESS_TOKEN", MODE_PRIVATE).edit();
                        if (token != null) editor.putString("token", token);
                        if (refreshToken != null) editor.putString("refreshToken", refreshToken);
                        editor.commit();
                        Toast.makeText(LoginActivity.this, "Login success",Toast.LENGTH_SHORT).show();
                        Log.d("Token", loginToken.getAccess_token());
                        editor = getSharedPreferences("ACCESS_TOKEN", MODE_PRIVATE).edit();
                        editor.putString("token", loginToken.getAccess_token());
                        editor.apply();
                        Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        //Send device token to server ================================
                        SharedPreferences settings = getApplicationContext().getSharedPreferences("device", Context.MODE_PRIVATE);
                        String deviceToken = settings.getString("deviceToken","");
                        Log.d("Device token nè==>",deviceToken);
                        userService = RetrofitGenerator.createService(UserService.class, token);
                        Response<UserDto> userResponse =  userService.sendDeviceToken(deviceToken).execute();
                        if(userResponse.isSuccessful()){
                            Log.d("Gửi token device", "XONG");
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Login fail. Please check your information again!", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                validateLoginUser();
                validateLoginPassword();
            }
        });
    }

    private boolean validateLoginUser() {
        String usernameInputLogin = et_login_name.getText().toString().trim();

        //validate username
        if (usernameInputLogin.isEmpty()) {
            userNameAlertLogin.setText("Trường không thể để trống. Vui lòng nhập tên người dùng");
            return false;
        }
        return true;
    }

    private boolean validateLoginPassword() {
        String passwordInputLogin = et_login_pass.getText().toString().trim();
        //validate pass
        if (passwordInputLogin.isEmpty()) {
            passwordAlertLogin.setText("Trường không thể để trống. Vui lòng nhập mật khẩu");
            return false;
        }
        if (passwordInputLogin.length() < 3) {
            passwordAlertLogin.setText("Mật khẩu phải có ít nhất 3 kí tự");
            return false;
        }
        return true;
    }

    private void redirectRegister() {
        redirect_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}