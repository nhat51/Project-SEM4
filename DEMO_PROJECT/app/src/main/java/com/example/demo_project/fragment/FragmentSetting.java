package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.activity.LoginActivity;
import com.example.demo_project.activity.RegisterActivity;
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.UserService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class FragmentSetting extends Fragment {
    private ImageView btn_back_setting;
    EditText startHourInput, startMinuteInput, endHourInput, endMinuteInput;
    TextView startTimeAlert, endTimeAlert;
    Button settingCancel, settingOk;
    private CardView log_out;
    private View view;
    private Context currentContext;
    private UserService userService;
    private String token = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_setting, container, false);

        initData();
        initBackView();
        initListener();
        logout();
        return view;
    }

    private void initListener() {
        settingOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String starHour = startHourInput.getText().toString();
                String startMins = startMinuteInput.getText().toString();
                String startTime = starHour.concat(":").concat(startMins);

                String endHour = endHourInput.getText().toString();
                String endMins = endMinuteInput.getText().toString();
                String endTime = endHour.concat(":").concat(endMins);

                Log.d("Notify Start Time", startTime);
                Log.d("Notify End Time", endTime);
                SharedPreferences settings = getActivity().getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE);
                token = settings.getString("token", "");
                if ( validateStartTime() && validateEndTime()){
                    if (userService == null){
                        userService = RetrofitGenerator.createService(UserService.class,token);
                    }
                    try {
                        Response<UserDto> listResponse = userService.setRemindTime(startTime,endTime).execute();
                        if (listResponse.isSuccessful()){
                            Log.d("Set remind time", "Thành công");
                            CharSequence charSequence = "Thành công";
                            Toast toast = Toast.makeText(currentContext.getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

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
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit();
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
        else if (inputStartMinute.isEmpty()){
            startTimeAlert.setText("Start minute is empty");
            return false;
        }
        if (inputStartHour.length() >= 23 ){
            startTimeAlert.setText("Start hour must not exceed 23 hours");
            return false;
        }
        if (inputStartMinute.length() >= 60){
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
        if (inputEndHour.length() >= 23 ){
            endTimeAlert.setText("End hour must not exceed 23 hours");
            return false;
        }
        if (inputEndMinute.length()>= 60){
            endTimeAlert.setText("End minute must not exceed 60 minutes");
            return false;
        }
        return true;
    }
    private void logout(){
        log_out = view.findViewById(R.id.log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}