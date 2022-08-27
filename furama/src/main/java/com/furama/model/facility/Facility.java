package com.furama.model.facility;

import com.furama.model.RentalType;
import com.furama.model.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacility;
    private String serviceName;
    private Double squareUse;
    private Double cost;
    private Integer numberOfPeople;

    private String roomStandard;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String freeServiceAdd;

    @ManyToOne
    private ServiceType serviceType;
    @ManyToOne
    private RentalType rentalType;
}
