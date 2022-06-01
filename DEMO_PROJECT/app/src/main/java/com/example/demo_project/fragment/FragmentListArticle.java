package com.example.demo_project.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.adapter.ListArticleAdapter;
import com.example.demo_project.adapter.ListWordAdapter;
import com.example.demo_project.entity.Article;
import com.example.demo_project.entity.ArticleResponse;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.ArticleService;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class FragmentListArticle extends Fragment {
    private List<Article> articles;
    private RecyclerView rvArticle;
    private ArticleService articleService;
    private ImageView btn_setting_list_article, btn_back_list_article;
    private View view;
    private Context currentContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_list_article, container, false);
        initView();
        initData();
        return view;
    }

    private void initView() {
        rvArticle = view.findViewById(R.id.rvArticle);
        rvArticle.setLayoutManager(new LinearLayoutManager(currentContext));
        rvArticle.setAdapter(new ListArticleAdapter(currentContext, articles));
    }
    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        articles = new ArrayList<>();
        if (articleService == null){
            articleService = RetrofitGenerator.createService(ArticleService.class);
        }
        try {
            Response<ArticleResponse> listResponse = articleService.getAllArticle().execute();
            Log.d("LOG: ", String.valueOf(listResponse.body().getContent().size()));
            if (listResponse.isSuccessful()){
                articles.addAll(listResponse.body().getContent());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
