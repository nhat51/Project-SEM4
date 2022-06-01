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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class FragmentDetailWord extends Fragment {
    TextView tvName_word_detail, tvPos_word_detail, tvWord_detail_meaning, tvPronounce_word_detail, tvWord_detail_example, tvWord_detail_example_trans;
    ImageView back_detail_word_page, search_detail_word_page, edit_detail_word_page;
    Word currentWord;
    WordService wordService;
    private View view;
    private Context currentContext;
    int wordId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_detail_word, container, false);
        initView();
        initData();
        initBackView();
        return view;
    }
    private void initView() {
        tvName_word_detail = view.findViewById(R.id.name_word_detail);
        tvPos_word_detail = view.findViewById(R.id.pos_detail_word);
        tvPronounce_word_detail = view.findViewById(R.id.tv_pronounce_word_detail);
        tvWord_detail_meaning = view.findViewById(R.id.word_detail_meaning);
        tvWord_detail_example = view.findViewById(R.id.word_detail_example);
        tvWord_detail_example_trans = view.findViewById(R.id.word_detail_example_trans);
        back_detail_word_page = view.findViewById(R.id.btn_back_detail_word_page);
        edit_detail_word_page = view.findViewById(R.id.btn_edit_detail_word_page);
        search_detail_word_page = view.findViewById(R.id.btn_search_detail_word_page);
    }
    private void initData() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            wordId = bundle.getInt("wordId");
            Log.d("wordId: ", String.valueOf(wordId));
        }
        if (wordService == null){
            wordService = RetrofitGenerator.createService(WordService.class);
        }
        try {
            Response<Word> wordDetailResponse = wordService.getWordDetail(wordId).execute();
            if (wordDetailResponse.isSuccessful()){
                currentWord = wordDetailResponse.body();
                tvName_word_detail.setText(currentWord.getName());
                tvPos_word_detail.setText(currentWord.getPartOfSpeech());
                tvWord_detail_meaning.setText(currentWord.getContent());
                tvWord_detail_example.setText(currentWord.getExample());
                tvWord_detail_example_trans.setText(currentWord.getTranslatedExample());
                tvPronounce_word_detail.setText(currentWord.getPronounce());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void initBackView() {
        back_detail_word_page = view.findViewById(R.id.btn_back_detail_word_page);
        back_detail_word_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_detail_word_page.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentListWord, FragmentListWord.class.getName())
                        .commit());
            }
        });
    }
//        words = (List<Word>) getIntent().getSerializableExtra("words");
//        currentPosition = getIntent().getIntExtra("position", 0);
//        currentWord = words.get(currentPosition);
//        tvName_word_detail.setText(currentWord.getName());
//        tvPos_word_detail.setText(currentWord.getName());
//        tvWord_detail_meaning.setText(currentWord.getName());
//        tvWord_detail_example.setText(currentWord.getName());
//        tvWord_detail_example_trans.setText(currentWord.getName());
//
//        words = new ArrayList<>();
//        if (wordService == null){
//            wordService = RetrofitGenerator.createService(WordService.class);
//        }
//        try {
//            Response<WordResponse> wordDetailResponse = wordService.getWordDetail().execute();
//            Log.d("wordssssss: ", String.valueOf(wordDetailResponse.body().getContent().size()));
//            if (wordDetailResponse.isSuccessful()){
//                words.addAll(wordDetailResponse.body().getContent());
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
}
