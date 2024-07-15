package com.example.finalpro.controllers;

import com.example.finalpro.dtos.LessonDto;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(value = "saveLesson")
    public String save(@RequestBody LessonDto lessonDto) {
        Lessons lesson = lessonDto.convertDtotoEntity(lessonDto);
        this.lessonService.save(lesson);
        return "saved";

    }

    @GetMapping(value = "readLesson")
    public LessonDto read(@RequestParam String name) {
        Lessons lesson = this.lessonService.findByname(name);
        return lesson.convertEntitytoDto(lesson);
    }

    @GetMapping(value = "updateLesson")
    public LessonDto update(@RequestBody LessonDto lessonDto) {
        this.lessonService.delete(lessonDto.getId());
        Lessons lesson = lessonDto.convertDtotoEntity(lessonDto);
        this.lessonService.save(lesson);
        return lessonDto;
    }

    @GetMapping(value = "deleteLesson")
    public String delete(@RequestParam String name) {
        Lessons lesson = this.lessonService.findByname(name);
        this.lessonService.delete(lesson.getId());
        return "deleted";

    }
}
