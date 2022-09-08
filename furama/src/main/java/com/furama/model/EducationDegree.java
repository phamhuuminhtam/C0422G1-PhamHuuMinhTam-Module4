package com.furama.model;

import com.furama.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "trinh_do")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_trinh_do")
    private Integer idEducation;
    @Column(name="ten_trinh_do")
    private String educationName;

    @OneToMany(mappedBy = "education")
    private List<Employee> employeeList;

}
