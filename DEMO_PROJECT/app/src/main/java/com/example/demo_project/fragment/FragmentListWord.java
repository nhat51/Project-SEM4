package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
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
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
public class FragmentListWord extends Fragment {
    private List<Word> words;
    private RecyclerView rvWord;
    private WordService wordService;
    private ImageView btn_back_list_word, btn_setting_list_word;
    private View view;
    private Context currentContext;
    public static FragmentDetailWord fragmentDetailWord;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_list_word, container, false);
        initBackView();
        initData();
        initView();
        initSettingView();
        return view;
    }
    private void initView() {
        rvWord = view.findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(currentContext));
        rvWord.setAdapter(new ListWordAdapter(currentContext, words));
    }
    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        words = new ArrayList<>();
        if (wordService == null){
            wordService = RetrofitGenerator.createService(WordService.class);
        }
        try {
            Response<WordResponse> listResponse = wordService.getAll().execute();
            Log.d("wordssssss: ", String.valueOf(listResponse.body().getContent().size()));
            if (listResponse.isSuccessful()){
                words.addAll(listResponse.body().getContent());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void initBackView() {
        btn_back_list_word = view.findViewById(R.id.btn_back_list_word);
        btn_back_list_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_back_list_word.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit());
            }
        });
    }
    private void initSettingView() {
        btn_setting_list_word = view.findViewById(R.id.btn_setting_list_word);
        btn_setting_list_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                btn_setting_list_word.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frameLayout, MainActivity.fragmentSetting, FragmentSetting.class.getName())
//                        .commit());
            }
        });
    }
}
