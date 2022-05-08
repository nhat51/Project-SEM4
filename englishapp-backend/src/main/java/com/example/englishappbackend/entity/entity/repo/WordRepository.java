package com.example.englishappbackend.entity.entity.repo;


import com.example.englishappbackend.entity.entity.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findWordsByUser_id(int userId);
}
