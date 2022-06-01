package com.example.demo_project.fragment;

import android.content.Context;
import android.os.Bundle;
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

public class FragmentDetailArticle extends Fragment {
    TextView article_title, main_content, article_created_at;
    ImageView btn_back_article_detail, btn_setting_article_detail;
    Article currentArticle;
    ArticleService articleService;
    private View view;
    private Context currentContext;
    int articleId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_detail_article, container, false);
        initView();
        return view;
    }

    private void initView() {
    }
}
