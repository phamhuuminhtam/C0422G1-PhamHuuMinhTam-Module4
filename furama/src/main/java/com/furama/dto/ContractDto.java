package com.furama.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name = "showTotal",
        query =
                "select hop_dong.ma_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,hop_dong.ma_dich_vu,hop_dong.ma_khach_hang,hop_dong.tien_dat_coc, CASE\n" +
                        "WHEN hop_dong_chi_tiet.so_luong IS NULL THEN dich_vu.chi_phi_thue\n" +
                        "ELSE dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)\n" +
                        "   END AS tong_tien\n" +
                        "    from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong \n" +
                        "left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem\n" +
                        "left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu group by hop_dong.ma_hop_dong;",
        resultSetMapping = "ContractDto"
)
@SqlResultSetMapping(
        name = "ContractDto",
        classes = @ConstructorResult(
                targetClass = ContractDto.class,
                columns = {
                        @ColumnResult(name = "ma_hop_dong", type = Integer.class),
                        @ColumnResult(name = "ngay_lam_hop_dong", type = String.class),
                        @ColumnResult(name = "ngay_ket_thuc", type = String.class),
                        @ColumnResult(name = "ma_dich_vu", type = Integer.class),
                        @ColumnResult(name = "ma_khach_hang", type = Integer.class),
                        @ColumnResult(name = "tien_dat_coc", type = Double.class),
                        @ColumnResult(name = "tong_tien", type = Double.class),
                }
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;
     private String startDate;
      private String endDate;
    private Integer idFacility;
    private Integer idCustomer;
    private Double deposit;
    private Double total;
}
