package com.exam.repository;

import com.exam.model.DiaDiem;
import com.exam.model.Xe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Time;

public interface XeRepository extends JpaRepository<Xe, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM exam.xe where `status` = 0 and bien_so like ?1 ", nativeQuery = true, countQuery = "select count(*) FROM exam.xe where `status` =0 and bien_so like ?1")
    Page<Xe> xePage(Pageable pageable, String key);

    @Modifying
    @Transactional
    @Query(value = "update exam.xe set status=1 where id= :id", nativeQuery = true)
    void delete(@Param("id")Integer id);

    @Transactional
    @Query(value ="select * from xe where id = :id",nativeQuery = true)
    Xe findByID(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `exam`.`xe` (`bien_so`, `email`, `gio_den`, `gio_khoi_hanh`, `loai_xe`, `so_dien_thoai`, `ten_nha_xe`, `diem_den_id`, `diem_di_id`, `status`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, '0')",nativeQuery = true)
    void  add(String bs, String email, Time gioDen, Time gioDi, String loaixe, String sdt, String tenNhaXe, Integer diemDen, Integer diemDi);

    @Modifying
    @Transactional
    @Query(value = "update xe set `bien_so` = ?1, `email` =?2, `gio_den`=?3, `gio_khoi_hanh`=?4, `loai_xe`=?5, `so_dien_thoai`=?6, `ten_nha_xe`=?7, `diem_den_id`=?8, `diem_di_id`=?9 where id = ?10",nativeQuery = true)
    void edit (String bs, String email, Time gioDen, Time gioDi, String loaixe, String sdt, String tenNhaXe, Integer diemDen, Integer diemDi, Integer id);
}
