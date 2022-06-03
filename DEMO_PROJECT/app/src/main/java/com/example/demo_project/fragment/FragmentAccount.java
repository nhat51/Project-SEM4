package com.example.demo_project.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;

public class FragmentAccount extends Fragment {
    private ImageView btn_back_account, btn_setting_account;
    private View view;
    private Context currentContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_account, container, false);
        initBackView();
        initSettingView();
        return view;
    }
    private void initBackView() {
        btn_back_account = view.findViewById(R.id.btn_back_account);
        btn_back_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_back_account.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit());
            }
        });
    }
    private void initSettingView() {
        btn_setting_account = view.findViewById(R.id.btn_setting_account);
        btn_setting_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_setting_account.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentSetting, FragmentSetting.class.getName())
                        .commit());
            }
        });
    }
}