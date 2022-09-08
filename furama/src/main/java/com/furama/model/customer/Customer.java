package com.furama.model.customer;


import com.furama.model.GuestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="khach_hang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_khach_hang")
    private Integer idCustomer;
    @Column(name="ho_ten")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="ngay_sinh")
    private LocalDate dayOfBirth;
    @Column(name="gioi_tinh")
    private Integer gender;
    @Column(name="so_cmnd")
    private String personalCode;
    @Column(name="so_dien_thoai")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name="ma_loai_khach", referencedColumnName="ma_loai_khach")
    private GuestType guestType;
}
