package com.example.webtech1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBodyRepository extends JpaRepository<UserBody, Long> {
    UserBody findByUsername(String username);
}