package com.example.finalpro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)

    private int id;

    @ManyToOne
    private Lessons lesson;
    @ManyToOne
    @JsonIgnore
    private Colleges college;
    @Column(unique = true)
    private String studentNumber;
    @Size(max = 48)
    private String name;
    @Size(max = 48)
    private String family;
    private String nationalCode;
    private String address;
    @OneToMany(mappedBy = "student")
    private List<Lessons>lessons;

}
