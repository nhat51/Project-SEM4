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
import com.example.demo_project.entity.Word;

import java.util.List;

public class FragmentDetailWord extends Fragment {
    TextView tvName_word_detail, tvPos_word_detail, tvWord_detail_meaning, tvWord_detail_example, tvWord_detail_example_trans;
    ImageView back_detail_word_page, search_detail_word_page, edit_detail_word_page;
    Word currentWord;
    List<Word> words;
    private View view;
    private Context currentContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_add_new_word, container, false);
        return view;
    }
}
