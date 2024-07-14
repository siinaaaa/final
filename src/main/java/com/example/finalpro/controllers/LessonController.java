package com.example.finalpro.controllers;

import com.example.finalpro.models.Lessons;
import com.example.finalpro.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(value = "save1")
    public String save(@RequestParam String name, @RequestParam int unit) {
        Lessons lessons = new Lessons();
        lessons.setName(name);
        lessons.setUnit(unit);
        lessonService.save(lessons);
        return "uuu";

    }
}
