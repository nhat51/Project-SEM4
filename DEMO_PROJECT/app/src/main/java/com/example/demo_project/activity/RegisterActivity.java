package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.User;
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.fragment.FragmentAddNewWordForm;
import com.example.demo_project.service.UserService;
import com.example.demo_project.util.RetrofitGenerator;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText et_register_name, et_register_email, et_register_phone, et_register_pass, et_register_pass_confirm,et_register_full_name;
    Button btn_register;
    TextView redirect_login, userNameAlert, fullNameAlert, emailAlert, phoneAlert, passwordAlert, passwordConfirmAlert;
    private TextWatcher text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
            initData();
            checkConfirmPassword();
            initListener();
            redirectLogin();
        }
    }

    private void checkConfirmPassword(){
        String password = et_register_pass.getText().toString();
        String checkPassword = et_register_pass_confirm.getText().toString();

        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {if (!password.equals(checkPassword)){
                // đưa ra lỗi.
                    passwordConfirmAlert.setText("Password not be matched. Please try again");
                }else {
                    passwordConfirmAlert.setText("Password Matched");
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };

        et_register_pass_confirm.addTextChangedListener(fieldValidatorTextWatcher);
    }

    private void redirectLogin(){
        redirect_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void initData(){
        et_register_name = findViewById(R.id.et_register_name);
        et_register_full_name = findViewById(R.id.et_register_full_name);
        et_register_email = findViewById(R.id.et_register_email);
        et_register_phone = findViewById(R.id.et_register_phone);
        et_register_pass = findViewById(R.id.et_register_pass);
        et_register_pass_confirm = findViewById(R.id.et_register_pass_confirm);
        redirect_login = findViewById(R.id.redirect_login);

        fullNameAlert = findViewById(R.id.FullNameAlert);
        userNameAlert = findViewById(R.id.UserNameAlert);
        emailAlert = findViewById(R.id.EmailAlert);
        phoneAlert = findViewById(R.id.PhoneAlert);
        passwordAlert = findViewById(R.id.PasswordAlert);
        passwordConfirmAlert = findViewById(R.id.PasswordConfirmAlert);

        btn_register = findViewById(R.id.btn_register);
    }

    private void initListener(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_register_name.getText().toString();
                String fullname = et_register_full_name.getText().toString();
                String email = et_register_email.getText().toString();
                String phone = et_register_phone.getText().toString();
                String password = et_register_pass.getText().toString();


                UserDto user = new UserDto();
                if (validateUserName()) user.setUsername(username);
                if (validateFullName()) user.setFullName(fullname);
                if (validateEmail()) user.setEmail(email);
                if (validatePhone()) user.setPhone(phone);
                if (validatePassword()) user.setPassword(password);

                UserService userService = RetrofitGenerator.createService(UserService.class);
                Log.d("Hello", new Gson().toJson(user));
                Response<UserDto> userCall = null;
                try {
                    userCall = userService.register(user).execute();
                    if(userCall.isSuccessful()){
                        CharSequence charSequence = "Tạo thành công";
                        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    CharSequence charSequence = e.getMessage();
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    private boolean validatePhone() {
        String phoneInput = et_register_phone.getText().toString().trim();
        if (phoneInput.isEmpty()) {
            phoneAlert.setText("Field can not be empty");
            return false;
        }
        if (!phoneInput.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
            phoneAlert.setText("Please enter a valid phone number");
            return false;
        }else {
            phoneAlert.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = et_register_pass.getText().toString().trim();
        //validate pass
        if (passwordInput.isEmpty()) {
            passwordAlert.setText("Field can not be empty");
            return false;
        }
        if (passwordInput.length() < 3) {
            passwordAlert.setText("Password must be at least 3 characters");
            return false;
        }
        return true;
    }
    private boolean validateEmail() {
        String emailInput = et_register_email.getText().toString().trim();
        if (emailInput.isEmpty()) {
            emailAlert.setText("Field can not be empty");
            return false;
            //sai định dạng
        } else if (!emailInput.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            emailAlert.setText("Please enter a valid email address");
            return false;
        } else {
            emailAlert.setError(null);
            return true;
        }
    }
    private boolean validateUserName() {
        String usernameInput = et_register_name.getText().toString().trim();
//        String noSpace = "(?=\\S+$)";
        if (usernameInput.isEmpty()) {
            userNameAlert.setText("Field cannot be empty");
            return false;
        }
        if (usernameInput.length() >= 15){
            userNameAlert.setText("Username has to less than 15 characters");
            return false;
        }
//        else if (!usernameInput.matches(noSpace)){
//            userNameAlert.setText("White spaces are not allowed");
//            return false;
//        }
        else {
            userNameAlert.setError(null);
            return true;
        }
    }
    private boolean validateFullName() {
        String fullnameInput = et_register_full_name.getText().toString().trim();
        if (fullnameInput.isEmpty()) {
            fullNameAlert.setText("Field cannot be empty");
            return false;
        }
        else {
            userNameAlert.setError(null);
            return true;
        }
    }
}