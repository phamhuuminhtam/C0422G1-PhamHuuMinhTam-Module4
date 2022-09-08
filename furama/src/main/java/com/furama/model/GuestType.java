package com.furama.model;


import com.furama.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="loai_khach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_loai_khach")
    private Integer idGuestType;
    @Column(name="ten_loai_khach")
    private String guestTypeName;

    @OneToMany(mappedBy = "guestType")
    private List<Customer> customerList;
}
