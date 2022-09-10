package com.furama.service.contract;

import com.furama.dto.AttachServiceFree;
import com.furama.dto.ContractDto;
import com.furama.dto.ContractPageDto;
import com.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
  List<ContractDto> showContract();

  Page<ContractPageDto> getContractPage(Pageable pageable);

  List<AttachServiceFree> getAttachServiceFree(Integer idc);

  Page<Contract> getCustomerPresent(Pageable pageable);

  Contract findByID(Integer id);

  Contract save(Contract contract);
}
