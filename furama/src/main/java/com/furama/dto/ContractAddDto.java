package com.furama.dto;

import com.furama.model.customer.Customer;
import com.furama.model.employee.Employee;
import com.furama.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractAddDto {
    private Integer idContract;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
}
