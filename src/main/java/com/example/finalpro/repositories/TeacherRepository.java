package com.example.finalpro.repositories;

import com.example.finalpro.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
    Teachers findByName(String name);
}
