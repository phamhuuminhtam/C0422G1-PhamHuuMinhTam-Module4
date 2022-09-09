package com.furama.service.contract;

import com.furama.dto.ContractDto;
import com.furama.dto.ContractPageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
  List<ContractDto> showContract();

  Page<ContractPageDto> getContractPage(Pageable pageable);
}
