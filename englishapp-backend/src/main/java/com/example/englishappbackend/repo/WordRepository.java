package com.example.englishappbackend.repo;


import com.example.englishappbackend.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {
    Page<Word> findWordsByUser_id(int userId, Pageable pageable);
}
