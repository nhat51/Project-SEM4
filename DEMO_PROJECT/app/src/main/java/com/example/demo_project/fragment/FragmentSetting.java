package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.activity.LoginActivity;
import com.example.demo_project.activity.RegisterActivity;

public class FragmentSetting extends Fragment {
    private ImageView btn_back_setting;
    EditText startHourInput, startMinuteInput, endHourInput, endMinuteInput;
    TextView startTimeAlert, endTimeAlert;
    Button settingCancel, settingOk;
    private CardView log_out;
    private View view;
    private Context currentContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_setting, container, false);

        initListener();
        initBackView();
        initData();
        logout();
        return view;
    }

    private void initListener() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                validateStartTime();
                validateEndTime();
            }
        });
    }

    private void initData() {
        startHourInput = view.findViewById(R.id.start_hour);
        startMinuteInput = view.findViewById(R.id.start_minute);
        endHourInput = view.findViewById(R.id.end_hour);
        endMinuteInput = view.findViewById(R.id.end_minute);
        startTimeAlert = view.findViewById(R.id.startTimeAlert);
        endTimeAlert = view.findViewById(R.id.endTimeAlert);
        settingCancel = view.findViewById(R.id.btn_remind_time_cancel);
        settingOk = view.findViewById(R.id.btn_remind_time_ok);
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
    private boolean validateStartTime(){
        String inputStartHour = startHourInput.getText().toString().trim();
        String inputStartMinute = startMinuteInput.getText().toString().trim();

        if (inputStartHour.isEmpty()){
            startTimeAlert.setText("Start hour is empty");
            return false;
        }
        if (inputStartMinute.isEmpty()){
            startTimeAlert.setText("Start minute is empty");
            return false;
        }
        if (inputStartHour.length() <= 23 ){
            startTimeAlert.setText("Start hour must not exceed 23 hours");
            return false;
        }
        if (inputStartMinute.length()<= 60){
            startTimeAlert.setText("Start minute must not exceed 60 minutes");
            return false;
        }
        return true;
    }
    private boolean validateEndTime(){
        String inputEndHour = endHourInput.getText().toString().trim();
        String inputEndMinute = endMinuteInput.getText().toString().trim();

        if (inputEndHour.isEmpty()){
            endTimeAlert.setText("End hour is empty");
            return false;
        }
        if (inputEndMinute.isEmpty()){
            endTimeAlert.setText("End minute is empty");
            return false;
        }
        if (inputEndHour.length() <= 23 ){
            endTimeAlert.setText("End hour must not exceed 23 hours");
            return false;
        }
        if (inputEndMinute.length()<= 60){
            endTimeAlert.setText("End minute must not exceed 60 minutes");
            return false;
        }
        return true;
    }
    private void logout(){

    }
}