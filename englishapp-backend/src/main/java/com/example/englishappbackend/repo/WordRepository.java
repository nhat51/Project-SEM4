package com.example.englishappbackend.repo;


import com.example.englishappbackend.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {
}
