package com.example.finalpro.services;

import com.example.finalpro.models.Lessons;
import com.example.finalpro.repositories.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private LessonRepository lessonRepository;
    public LessonService(LessonRepository lessonRepository){
        this.lessonRepository=lessonRepository;
    }
    public Lessons save(Lessons lessons){
        return this.lessonRepository.save(lessons);
    }
    public Lessons findByname(String name){
        return this.lessonRepository.findByName(name);
    }
    public String delete(int id){
        this.lessonRepository.deleteById(id);
        return "";
    }
}
