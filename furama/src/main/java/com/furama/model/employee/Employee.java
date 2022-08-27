package com.furama.model.employee;


import com.furama.model.Division;
import com.furama.model.EducationDegree;
import com.furama.model.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;
    private String personalCode;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private EducationDegree education;
    @ManyToOne
    private Division division;
    @ManyToOne
    private Position position;

    private Double salary;
}