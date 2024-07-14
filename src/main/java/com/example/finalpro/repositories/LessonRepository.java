package com.example.finalpro.repositories;

import com.example.finalpro.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lessons, Integer> {
}
