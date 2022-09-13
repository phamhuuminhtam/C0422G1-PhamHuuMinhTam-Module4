package com.furama.model;

import com.furama.model.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hop_dong_chi_tiet")
public class  ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_hop_dong_chi_tiet")
    private Integer idContractDetail;
    @Column(name="so_luong")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="ma_hop_dong",referencedColumnName = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="ma_dich_vu_di_kem", referencedColumnName ="ma_dich_vu_di_kem" )
    private AttachFacility attachFacility;


}
