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

import androidx.fragment.app.Fragment;

import com.example.demo_project.R;
import com.example.demo_project.entity.Article;
import com.example.demo_project.entity.Word;
import com.example.demo_project.service.ArticleService;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;

import retrofit2.Response;

public class FragmentDetailArticle extends Fragment {
    TextView article_title, main_content, article_created_at;
    ImageView btn_back_article_detail, btn_setting_article_detail;
    Article currentArticle;
    ArticleService articleService;
    private View view;
    private String token = null;
    private Context currentContext;
    int articleId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_detail_article, container, false);
        initView();
        initData();
        return view;
    }

    private void initView() {
        article_title = view.findViewById(R.id.article_title);
        main_content = view.findViewById(R.id.main_content);
        article_created_at = view.findViewById(R.id.article_created_at);
        btn_back_article_detail = view.findViewById(R.id.btn_back_article_detail);
        btn_setting_article_detail = view.findViewById(R.id.btn_setting_article_detail);
    }
    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            articleId = bundle.getInt("articleId");
            Log.d("articleId: ", String.valueOf(articleId));
        }
        if (articleService == null){
            articleService = RetrofitGenerator.createService(ArticleService.class, token);
        }
        try {
            Response<Article> articleDetailResponse = articleService.getArticleDetail(articleId).execute();
            if (articleDetailResponse.isSuccessful()){
                currentArticle = articleDetailResponse.body();
                article_title.setText(currentArticle.getTitle());
                article_created_at.setText(currentArticle.getCreatedAt());
                main_content.setText(currentArticle.getContent());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
