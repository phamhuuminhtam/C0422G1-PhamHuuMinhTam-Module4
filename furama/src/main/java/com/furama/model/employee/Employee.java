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
@Table(name = "nhan_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer idEmployee;
    @Column(name = "ho_ten")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_sinh")
    private LocalDate dayOfBirth;
    @Column(name = "so_cmnd")
    private String personalCode;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name="ma_trinh_do", referencedColumnName="ma_trinh_do")
    private EducationDegree education;
    @ManyToOne
    @JoinColumn(name="ma_bo_phan", referencedColumnName="ma_bo_phan")
    private Division division;
    @ManyToOne
    @JoinColumn(name="ma_vi_tri", referencedColumnName="ma_vi_tri")
    private Position position;

    @Column(name= "luong")
    private Double salary;
    @Column(name = "dia_chi")
    private String address;
}