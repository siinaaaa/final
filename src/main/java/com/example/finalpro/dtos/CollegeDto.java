package com.example.finalpro.dtos;

import com.example.finalpro.models.Colleges;
import com.example.finalpro.models.Lessons;
import com.example.finalpro.models.Students;
import com.example.finalpro.models.Teachers;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CollegeDto {

    private int id;
    private String name;
    private Teachers manager;
    private List<Teachers> teachers;
    private List<Students>students;
    private List<Lessons>lessons;



    public Colleges convertDtotoEntity(CollegeDto collegeDto){
        Colleges college = new Colleges();
        college.setName(collegeDto.getName());
        return college;
    }


}
