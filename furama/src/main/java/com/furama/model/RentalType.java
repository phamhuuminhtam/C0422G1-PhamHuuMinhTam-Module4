package com.furama.model;

import com.furama.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kieu_thue")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_kieu_thue")
    private int idRentalType;
    @Column(name="ten_kieu_thue")
    private String rentalTypeName;

    @OneToMany(mappedBy = "rentalType")
    private List<Facility> facilityList;


}
