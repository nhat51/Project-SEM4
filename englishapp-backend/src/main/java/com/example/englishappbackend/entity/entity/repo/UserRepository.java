package com.example.englishappbackend.entity.entity.repo;

import com.example.englishappbackend.entity.entity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
