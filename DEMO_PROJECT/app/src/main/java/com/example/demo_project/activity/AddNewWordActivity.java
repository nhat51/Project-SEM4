package com.example.demo_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;

public class AddNewWordActivity extends AppCompatActivity {
    private EditText etWord, etWordMeaning, etPartOfSpeech;
    private Button btnSubmit;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }
        initData();
        initListener();

    }
    private void initData() {
        etWord = findViewById(R.id.etWord);
        etWordMeaning = findViewById(R.id.etWordMeaning);
        etPartOfSpeech = findViewById(R.id.etPartOfSpeech);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = etWord.getText().toString();
                String meaningWord = etWordMeaning.getText().toString();
                String partOfSpeech = etPartOfSpeech.getText().toString();

                Word newWord = new Word();
                newWord.setName(word);
                newWord.setContent(meaningWord);
                newWord.setPart_of_speech(partOfSpeech);
                Toast.makeText(AddNewWordActivity.this, "Add new word successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

}