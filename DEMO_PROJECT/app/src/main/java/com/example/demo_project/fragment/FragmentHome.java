package com.example.demo_project.fragment;

import android.content.Context;
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
import com.example.demo_project.entity.UserDto;
import com.example.demo_project.service.UserService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class FragmentHome extends Fragment {
    TextView user_nameHomeFragment;
    int userId;
    private UserService userService;
    private UserDto currentUser1;
    private View view;
    private Context currentContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView txtRememberViewMore = view.findViewById(R.id.remember_view_more);
        txtRememberViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWordRemember, FragmentListWordRemember.class.getName())
                .commit());

        TextView txtAllViewMore = view.findViewById(R.id.all_view_more);
        Log.d("Errror", String.valueOf(txtAllViewMore == null) );
        txtAllViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWord, FragmentListWord.class.getName())
                .commit());

        TextView txtRemindViewMore = view.findViewById(R.id.remind_view_more);
        txtRemindViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWordRemind, FragmentListWordRemind.class.getName())
                .commit());

        ImageView ivMoreArticle = view.findViewById(R.id.more_article);
        ivMoreArticle.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListArticle, FragmentListArticle.class.getName())
                .commit());

        initView();
        getUsername();
        return view;
    }

    private void initView() {
        user_nameHomeFragment = view.findViewById(R.id.user_nameHomeFragment);
    }

    private void getUsername() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            userId = bundle.getInt("userId");
            Log.d("wordId: ", String.valueOf(userId));
        }
        if (userService == null){
            userService = RetrofitGenerator.createService(UserService.class);
        }
        try {
            Response<UserDto> userResponse = userService.getUserAccountDetails(userId).execute();
            if (userResponse.isSuccessful()){
                currentUser1 = userResponse.body();
                user_nameHomeFragment.setText(currentUser1.getFullName());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
