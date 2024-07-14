package com.example.finalpro.controllers;

import com.example.finalpro.dtos.CollegeDto;
import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Teachers;
import com.example.finalpro.services.CollegeService;
import com.example.finalpro.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollegeController {
    private CollegeService collegeService;
    private TeacherService teacherService;

    @Autowired
    public CollegeController(CollegeService collegeService, TeacherService teacherService) {
        this.teacherService = teacherService;
        this.collegeService = collegeService;
    }

    @GetMapping(value = "saveManager")
    public String saveManager(@RequestParam String name, @RequestParam String teacherName) {
        Teachers teacher = this.teacherService.findByname(teacherName);
        Colleges colleges = this.collegeService.findByname(name);
        List<Teachers> teachers = colleges.getTeachers();
        if (teachers.contains(teacher)) {
            colleges.setManager(teacher);
            this.collegeService.save(colleges);
            return "saved";
        }
        return "not saved";
    }
    @GetMapping(value = "saveCollege")
    public String save(@RequestBody CollegeDto collegeDto){

        Colleges college = collegeDto.convertDtotoEntity(collegeDto);
        this.collegeService.save(college);
        return "saved";
    }
    @GetMapping("allColleges")
    public List<Colleges> readAll(){
        return this.collegeService.colleges();
    }
    @GetMapping(value = "readCollege")
    public CollegeDto read(@RequestParam String name){
        Colleges college = this.collegeService.findByname(name);
        CollegeDto collegeDto = college.convertEntitytoDto(college);
        return collegeDto;

    }
    @GetMapping(value = "updateCollege")
     public CollegeDto update(@RequestBody CollegeDto collegeDto){
        this.collegeService.delete(collegeDto.getId());
        Colleges college2 = collegeDto.convertDtotoEntity(collegeDto);
        this.collegeService.save(college2);
         return collegeDto;
    }
    @GetMapping(value = "deleteCollege")
    public String delete(String name){
        Colleges college = this.collegeService.findByname(name);
        this.collegeService.delete(college.getId());
        return "deleteed";
    }

}
