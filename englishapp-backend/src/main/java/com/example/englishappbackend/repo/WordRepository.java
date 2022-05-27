package com.example.englishappbackend.repo;


import com.example.englishappbackend.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer>, JpaSpecificationExecutor<Word> {
    Page<Word> findWordsByUser_id(int userId, Pageable pageable);
}
