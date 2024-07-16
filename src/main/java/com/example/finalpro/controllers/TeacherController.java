package com.example.finalpro.controllers;

import com.example.finalpro.dtos.TeacherDto;
import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Teachers;
import com.example.finalpro.services.CollegeService;
import com.example.finalpro.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;
    private CollegeService collegeService;

    @Autowired
    public TeacherController(TeacherService teacherService, CollegeService collegeService) {
        this.collegeService = collegeService;
        this.teacherService = teacherService;
    }

    @GetMapping(value = "saveTeacher")
    public String save(@RequestBody TeacherDto teacherDto) {
        Teachers teacher = new Teachers();
        teacher.setFamily(teacherDto.getFamily());
        teacher.setName(teacherDto.getName());
        teacher.setNationalCode(teacherDto.getNationalCode());
        teacher.setPersonalyCode(teacherDto.getPersonalyCode());
        teacher.setCollege(teacherDto.getCollege());
        List<Lessons> lessons = teacherDto.getLessons();
        Colleges college = this.collegeService.findByname(teacherDto.getCollege().getName());
        List<Lessons> list = college.getLessons();
        List<Lessons> lessonsList = new ArrayList<>();
        for (int i = 0; i < lessons.size(); i++) {
            if (list.contains(lessons.get(i))) {
                lessonsList.add(lessons.get(i));
            }
        }
        teacher.setLessons(lessonsList);
        lessonsList.clear();
        return "saved";


    }

    @GetMapping(value = "readTeacher")
    public TeacherDto read(@RequestParam String name) {
        Teachers teacher = this.teacherService.findByname(name);
        return teacher.convertEntitytoDto(teacher);

    }

    @GetMapping(value = "deleteTeacher")
    public TeacherDto delete(@RequestParam String name) {
        Teachers teacher = this.teacherService.findByname(name);
        this.teacherService.delete(teacher.getId());
        return teacher.convertEntitytoDto(teacher);

    }

    @GetMapping(value = "updateTeacher")
    public TeacherDto update(@RequestBody TeacherDto teacherDto) {
        Teachers teacher = this.teacherService.findByname(teacherDto.getName());
        this.teacherService.delete(teacher.getId());
        this.teacherService.save(teacherDto.convertDtotoEntity(teacherDto));
        return teacherDto;


    }


}
