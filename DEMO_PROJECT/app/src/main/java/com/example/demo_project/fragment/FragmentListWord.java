package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.activity.LoginActivity;
import com.example.demo_project.adapter.ListWordAdapter;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.entity.WordsByUserResponse;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.PaginationScrollListener;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class FragmentListWord extends Fragment {

    private int currentWordId = 0;
    private List<Word> words;
    private RecyclerView rvWord;
    private WordService wordService;
    private ImageView btn_back_list_word, btn_setting_list_word;
    private View view;
    private ListWordAdapter listWordAdapter;
    private Context currentContext;
    public static FragmentDetailWord fragmentDetailWord;
    private String token = null;
    private boolean isLoading;
    private boolean isLastPage;
    private int totalPage = 5;
    private int currentPage = 1;
    private int limit = 2;

    private void setFirstData() {
        words = getWords();
        listWordAdapter.setData(words);
        Log.d("currentPage<=totalPage", String.valueOf(currentPage <= totalPage));
        if (currentPage <= totalPage) {
            listWordAdapter.addFooterLoading();
        } else {
            isLastPage = true;
        }
    }

    private List<Word> getWords() {
        Toast.makeText(currentContext, "Current page: " + currentPage, Toast.LENGTH_SHORT).show();
        Call<WordsByUserResponse> wordsByUserResponseCall = wordService.getWordsByUser(currentPage, limit);
        try {
            Response<WordsByUserResponse> wordsByUserResponse = wordsByUserResponseCall.execute();
            if (wordsByUserResponse.isSuccessful()) {
                WordsByUserResponse userWordResponse = wordsByUserResponse.body();
                totalPage = userWordResponse.getTotalPages();
                Log.d("Load List word", String.format("Total page: %d, current page: %d, total elements: %d", totalPage, currentPage, userWordResponse.getNumberOfElements()));
                if (currentPage < totalPage) {
                    isLastPage = false;
                } else {
                    isLastPage = true;
                }
                return userWordResponse.getContent();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Got Error.");
        }
        return new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Logging", "OnCreateView fragmentlistWord");
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_list_word, container, false);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        SharedPreferences settings = getActivity().getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE);
        token = settings.getString("token", "");
        Log.d("Logged in with token: ", token);
        if (wordService == null) {
            wordService = RetrofitGenerator.createService(WordService.class, token);
        }
        // reset variable related paging
        currentPage = 1;
        initView();
        return view;
    }

    private void initView() {
        // init recycler view.
        rvWord = view.findViewById(R.id.rvWord);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(currentContext);
        rvWord.setLayoutManager(linearLayoutManager);
        listWordAdapter = new ListWordAdapter(currentContext, words);
        rvWord.setAdapter(listWordAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(currentContext, DividerItemDecoration.VERTICAL);
        rvWord.addItemDecoration(itemDecoration);
        setFirstData();
        rvWord.setOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            public void loadMoreItems() {
                if (!isLoading && totalPage > currentPage) {
                    isLoading = true;
                    currentPage++;
                    loadNextPage();
                }
            }

            @Override
            public boolean isLoading() {
                return false;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }
        });
        // init another things
        fragmentDetailWord = new FragmentDetailWord();
        initBackView();
        initSettingView();
    }

    private void loadNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Word> updatedWord = getWords();
                listWordAdapter.removeFooterLoading();
                words.addAll(updatedWord);
                listWordAdapter.notifyDataSetChanged();
                isLoading = false;
                if (currentPage < totalPage) {
                    listWordAdapter.addFooterLoading();
                } else {
                    isLastPage = true;
                }
            }
        }, 2000);
    }

    private void initBackView() {
        btn_back_list_word = view.findViewById(R.id.btn_back_list_word);
        btn_back_list_word.setOnClickListener(new View.OnClickListener() {
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
        btn_setting_list_word = view.findViewById(R.id.btn_setting_list_word);
        btn_setting_list_word.setOnClickListener(new View.OnClickListener() {
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
