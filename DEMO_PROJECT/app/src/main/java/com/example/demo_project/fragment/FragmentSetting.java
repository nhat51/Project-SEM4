package com.example.demo_project.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;

public class FragmentSetting extends Fragment {
    private ImageView btn_back_setting;
    private CardView log_out;
    private View view;
    private Context currentContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_setting, container, false);

        initBackView();
        return view;
    }
    private void initBackView() {
        btn_back_setting = view.findViewById(R.id.btn_back_setting);
        btn_back_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_back_setting.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit());
            }
        });
    }
    private boolean logout(){
       return true;
    }
}