package com.example.finalpro.controllers;

import com.example.finalpro.models.Teachers;
import com.example.finalpro.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "save")
    public String save(@RequestParam String name, @RequestParam String family, @RequestParam String nationalCode, @RequestParam String personalyCode) {
        Teachers teacher = new Teachers();
        teacher.setName(name);
        teacher.setFamily(family);
        teacher.setNationalCode(nationalCode);
        teacher.setPersonalyCode(personalyCode);
        teacherService.save(teacher);
        return "ppo";


    }
}
