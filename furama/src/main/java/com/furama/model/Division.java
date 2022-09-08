package com.furama.model;

import com.furama.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bo_phan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_bo_phan")
    private Integer idDivision;
    @Column(name="ten_bo_phan")
    private String divisionName;
    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;
}
