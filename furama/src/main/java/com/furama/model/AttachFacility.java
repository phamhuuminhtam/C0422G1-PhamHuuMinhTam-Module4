package com.furama.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dich_vu_di_kem")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer idAttachFacility;
    @Column(name="ten_dich_vu_di_kem")
    private  String nameAttachFacility;
    @Column(name="gia")
    private Double price;
    @Column(name="don_vi")
    private Integer unit;
    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;




}
