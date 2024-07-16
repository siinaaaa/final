package com.example.finalpro.repositories;

import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    Students findByName(String name);
}
