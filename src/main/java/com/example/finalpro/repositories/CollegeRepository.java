package com.example.finalpro.repositories;

import com.example.finalpro.models.Colleges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<Colleges, Integer> {
    Colleges findByName(String name);
}
