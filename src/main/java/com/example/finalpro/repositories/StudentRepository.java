package com.example.finalpro.repositories;

import com.example.finalpro.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    Students findByName(String name);
}
