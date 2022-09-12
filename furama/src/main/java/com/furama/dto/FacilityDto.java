package com.furama.dto;

import com.furama.model.RentalType;
import com.furama.model.ServiceType;
import com.furama.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto implements Validator {

    private Integer idFacility;
    @NotBlank
    private String serviceName;
    @NotNull
    @Min(value = 0)
    private Double squareUse;
    @NotNull
    @Min(value = 0)
    private Double cost;
    @NotNull
    @Min(value = 0)
    private Integer numberOfPeople;

    private String roomStandard;

    private String descriptionOtherConvenience;

    private Double poolArea;

    private Integer numberOfFloors;

    private String freeServiceAdd;

    private ServiceType serviceType;

    private RentalType rentalType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facility = (FacilityDto)  target;
      if(facility.getServiceType().getIdServiceType()!=3){
          if(facility.getRoomStandard().trim().equals("")){
              errors.rejectValue("roomStandard","roomStandard.error","Vui lòng nhập tiêu chuẩn phòng");
          }
          if(facility.getDescriptionOtherConvenience().trim().equals("")){
              errors.rejectValue("descriptionOtherConvenience","descriptionOtherConvenience.error","Vui lòng nhập mô tả tiện ích");
          }
          if( facility.getNumberOfFloors() == null){
              errors.rejectValue("numberOfFloors","numberOfFloors.error","Vui lòng nhập số tầng");
          }else if(facility.getNumberOfFloors() <= 0) {
              errors.rejectValue("numberOfFloors","numberOfFloors.error","Vui lòng nhập số tầng đúng định dạng");
          }
      }
      if(facility.getServiceType().getIdServiceType()==1){
          if (facility.getPoolArea()==null){
              errors.rejectValue("poolArea","poolArea.error","Vui lòng nhập diện tích hồ bơi");
          }else if(facility.getPoolArea() <=0){
              errors.rejectValue("poolArea","poolArea.error","Vui lòng nhập diện tích hồ bơi đúng định dạng");
          }

      }

    }
}
