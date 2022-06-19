package com.example.englishappbackend.repo;


import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.specification.WordSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WordRepository extends JpaRepository<Word, Integer>, JpaSpecificationExecutor<Word> {
    Page<Word> findWordsByUserId(int userId, Pageable pageable);
    Word findWordByUserAndName(int userId,String name);
}
