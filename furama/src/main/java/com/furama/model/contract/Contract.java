package com.furama.model.contract;

import com.furama.model.ContractDetail;
import com.furama.model.customer.Customer;
import com.furama.model.employee.Employee;
import com.furama.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_hop_dong")
    private Integer idContract;
    @Column(name="ngay_lam_hop_dong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="ngay_ket_thuc")
    private LocalDate endDate;
    @Column(name="tien_dat_coc")
    private Double deposit;

    @ManyToOne
    @JoinColumn(name="ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="ma_dich_vu", referencedColumnName = "ma_dich_vu")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;

}
