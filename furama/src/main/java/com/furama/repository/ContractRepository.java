package com.furama.repository;

import com.furama.dto.ContractDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContractRepository extends JpaRepository<ContractDto, Integer> {
    @Query(name = "showTotal", nativeQuery = true)
    List<ContractDto> showContract();

}
