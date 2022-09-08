package com.furama.model;


import com.furama.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vi_tri")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_vi_tri")
    private Integer idPosition;
    @Column(name="ten_vi_tri")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;
}
