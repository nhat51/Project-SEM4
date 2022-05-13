package com.example.demo_project.activity;

import com.example.demo_project.entity.Word;

import junit.framework.TestCase;

import java.util.List;

public class AddNewWordActivityTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }
    private static WordDatabase db;
    public void testOnCreate() {

    }

    public static void main(String[] args) {
        List<Word> list = db.wordDao().getAllWord();
        for (Word w : list){
            System.out.println(w.name);
        }
    }
}