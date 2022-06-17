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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.adapter.ListWordAdapter;
import com.example.demo_project.entity.Word;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class FragmentListWordRemind extends Fragment {
    private List<Word> listWordRemind;
    private RecyclerView rvWord;
    private WordService wordService;
    private ImageView btn_back_list_word_remind, btn_edit_remind_list;
    private View view;
    private Context currentContext;
    public static FragmentDetailWord fragmentDetailWord;
    private String token = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_list_word_remind, container, false);
        return view;
    }
    private void initView() {
        rvWord = view.findViewById(R.id.rvRemind_Word);
        rvWord.setLayoutManager(new LinearLayoutManager(currentContext));
        rvWord.setAdapter(new ListWordAdapter(currentContext, listWordRemind));

        fragmentDetailWord = new FragmentDetailWord();
    }
    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        listWordRemind = new ArrayList<>();
        SharedPreferences settings = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = settings.getString("token", "");
        String refreshToken = settings.getString("refreshToken", "");
        Log.d("token", token);
        Log.d("refreshToken", refreshToken);
        if (wordService == null){
            wordService = RetrofitGenerator.createService(WordService.class,token);
        }
        try {
            Response<List<Word>> listResponse = wordService.getRemindWord().execute();
//            Log.d("wordssssss: ", String.valueOf(listResponse.body().getContent().size()));
            if (listResponse.isSuccessful()){
                Log.d("Check check check","+++++++++++++++++++++++++++++");
                listWordRemind.addAll(listResponse.body());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void initBackView() {
        btn_back_list_word_remind = view.findViewById(R.id.btn_back_remind_list);
        btn_back_list_word_remind.setOnClickListener(new View.OnClickListener() {
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
        btn_edit_remind_list = view.findViewById(R.id.btn_edit_remind_list);
        btn_edit_remind_list.setOnClickListener(new View.OnClickListener() {
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
