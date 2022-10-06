package com.exam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bienSo;
    private String loaiXe;
    @NotBlank
    private String tenNhaXe;
    @ManyToOne
    private DiaDiem diemDen;
    @ManyToOne
    private DiaDiem diemDi;
    private String soDienThoai;
    private String email;
    private Time gioKhoiHanh;
    private Time gioDen;
    private Integer status;
}
