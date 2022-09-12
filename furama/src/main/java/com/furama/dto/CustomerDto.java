package com.furama.dto;

import com.furama.model.GuestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {


    private Integer idCustomer;

    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    @Pattern(regexp = "^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)+$",message = "Vui lòng nhập đúng định dạng")
    private String name;

    @NotNull(message = "Vui lòng nhập ngày sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;
    @NotNull
    private Integer gender;
    @NotBlank(message = "Vui lòng nhập chứng minh nhân dân/ giấy tờ tùy thân")
    @Pattern(regexp = "[0-9]{9,12}",message = "Vui lòng nhập đúng định dạng")
    private String personalCode;
    @NotBlank(message = "Vui lòng nhập số điện thoại khách hàng")
    @Pattern(regexp = "^(090|091|(84)\\+90|(84)\\+91)[0-9]{7}$",message = "Vui lòng nhập đúng định dạng")
    private String phoneNumber;
    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập dịa chỉ")
    private String address;
    @NotNull
    private GuestType guestType;


}
