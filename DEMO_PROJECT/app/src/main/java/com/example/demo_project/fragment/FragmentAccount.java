package com.example.demo_project.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.User;
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.entity.Word;
import com.example.demo_project.service.UserService;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class FragmentAccount extends Fragment {
    private ImageView btn_back_account, btn_setting_account;
    private TextView name_user, email_user, phone_user;
    private View view;
    private Context currentContext;
    private UserService userService;
    UserDto currentUser;
    private String token = null;
    int userId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_account, container, false);
        initView();
        initData();
        initBackView();
        initSettingView();
        return view;
    }

    private void initView() {
        name_user = view.findViewById(R.id.name_user);
        email_user = view.findViewById(R.id.email_user);
        phone_user = view.findViewById(R.id.phone_user);
    }

    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SharedPreferences settings = getActivity().getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE);
        token = settings.getString("token", "");
        Log.d("Logged in with token: ", token);
        if (userService == null) {
            userService = RetrofitGenerator.createService(UserService.class, token);
        }
        try {
            Response<UserDto> userResponse = userService.getUserAccountDetails(userId).execute();
            if (userResponse.isSuccessful()){
                currentUser = userResponse.body();
                name_user.setText(currentUser.getUsername());
                email_user.setText(currentUser.getEmail());
                phone_user.setText(currentUser.getPhone());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initBackView() {
        btn_back_account = view.findViewById(R.id.btn_back_account);
        btn_back_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit();
            }
        });
    }
    private void initSettingView() {
        btn_setting_account = view.findViewById(R.id.btn_setting_account);
        btn_setting_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentSetting, FragmentSetting.class.getName())
                        .commit();
            }
        });
    }
}