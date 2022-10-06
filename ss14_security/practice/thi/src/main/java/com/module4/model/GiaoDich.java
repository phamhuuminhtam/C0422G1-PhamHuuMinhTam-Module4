package com.module4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class GiaoDich {
    @Id
    private String id;

    private LocalDate date;

    private Double price;

    private Double area;

    @ManyToOne
     private Customer customer;

    @ManyToOne
    private TypeService typeService;

    public GiaoDich() {
    }

    public GiaoDich(String id, LocalDate date, Double price, Double area, Customer customer, TypeService typeService) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.area = area;
        this.customer = customer;
        this.typeService = typeService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}
