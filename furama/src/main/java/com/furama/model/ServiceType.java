package com.furama.model;

import com.furama.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="loai_dich_vu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_loai_dich_vu")
    private Integer idServiceType;
    @Column(name="ten_loai_dich_vu")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private List<Facility> facilityList;
}
