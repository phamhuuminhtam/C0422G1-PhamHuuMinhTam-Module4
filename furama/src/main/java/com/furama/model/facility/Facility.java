package com.furama.model.facility;

import com.furama.model.RentalType;
import com.furama.model.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="dich_vu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_dich_vu")
    private Integer idFacility;
    @Column(name="ten_dich_vu")
    private String serviceName;
    @Column(name="dien_tich")
    private Double squareUse;
    @Column(name="chi_phi_thue")
    private Double cost;
    @Column(name="so_nguoi_toi_da")
    private Integer numberOfPeople;
    @Column(name="tieu_chuan_phong")
    private String roomStandard;
    @Column(name="mo_ta_tien_nghi_khac")
    private String descriptionOtherConvenience;
    @Column(name="dien_tich_ho_boi")
    private Double poolArea;
    @Column(name="so_tang")
    private Integer numberOfFloors;
    @Column(name="dich_vu_mien_phi_di_kem")
    private String freeServiceAdd;

    @ManyToOne
    @JoinColumn(name="ma_loai_dich_vu", referencedColumnName="ma_loai_dich_vu")
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name="ma_kieu_thue", referencedColumnName="ma_kieu_thue")
    private RentalType rentalType;
}
