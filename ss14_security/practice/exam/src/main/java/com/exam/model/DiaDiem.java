package com.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonBackReference(value = "xe2")
    @OneToMany(mappedBy = "diemDen")
    private List<Xe> xeListDen;
    @JsonBackReference(value = "xe1")
    @OneToMany(mappedBy = "diemDi")
    private List<Xe> xeListDi;

}
