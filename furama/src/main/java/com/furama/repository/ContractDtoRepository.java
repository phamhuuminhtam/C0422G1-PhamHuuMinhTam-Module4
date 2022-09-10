package com.furama.repository;

import com.furama.dto.AttachServiceFree;
import com.furama.dto.ContractDto;
import com.furama.dto.ContractPageDto;
import com.furama.model.contract.Contract;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface ContractDtoRepository extends JpaRepository<ContractDto, Integer> {
    @Query(name = "showTotal", nativeQuery = true)
    List<ContractDto> showContract();

    @Query(value = "select hop_dong.ma_hop_dong as id,dich_vu.ten_dich_vu as facility, khach_hang.ho_ten as customer, hop_dong.ngay_lam_hop_dong as start,hop_dong.ngay_ket_thuc as ends,hop_dong.tien_dat_coc as deposit, CASE\n" +
            "    WHEN hop_dong_chi_tiet.so_luong IS NULL THEN dich_vu.chi_phi_thue\n" +
            "                ELSE dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)\n" +
            "                END AS total\n" +
            "                   from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong \n" +
            "                   left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem\n" +
            "                   left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu \n" +
            "                   left join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang\n" +
            "                   group by hop_dong.ma_hop_dong ", nativeQuery = true, countQuery = "select count(*) from (select hop_dong.ma_hop_dong as id,dich_vu.ten_dich_vu as facility, khach_hang.ho_ten as customer, hop_dong.ngay_lam_hop_dong as start,hop_dong.ngay_ket_thuc as ends,hop_dong.tien_dat_coc as deposit, CASE\n" +
            "    WHEN hop_dong_chi_tiet.so_luong IS NULL THEN dich_vu.chi_phi_thue\n" +
            "                ELSE dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)\n" +
            "                END AS total\n" +
            "                   from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong \n" +
            "                   left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem\n" +
            "                   left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu \n" +
            "                   left join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang\n" +
            "                   group by hop_dong.ma_hop_dong) as pageCount ")
    Page<ContractPageDto> getContractPage(Pageable pageable);

    @Query(value = "select hop_dong.ma_hop_dong as idc, ten_dich_vu_di_kem as name ,gia as price ,don_vi as unit ,trang_thai as status,so_luong as quantity\n" +
            "    from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong \n" +
            "left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem where hop_dong.ma_hop_dong = ?1", nativeQuery = true)
    List<AttachServiceFree> getAttachServiceFree(Integer idc);




}
