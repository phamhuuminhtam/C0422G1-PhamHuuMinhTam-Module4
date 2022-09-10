package com.furama.service.contract;

import com.furama.dto.AttachServiceFree;
import com.furama.dto.ContractDto;
import com.furama.dto.ContractPageDto;
import com.furama.model.contract.Contract;
import com.furama.repository.ContractDtoRepository;
import com.furama.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDtoRepository contractRepository;

    @Autowired
    private ContractRepository contractRepositoryNew;

    @Override
    public List<ContractDto> showContract() {
        return contractRepository.showContract();
    }

    @Override
    public Page<ContractPageDto> getContractPage(Pageable pageable) {
        return contractRepository.getContractPage(pageable);
    }

    @Override
    public List<AttachServiceFree> getAttachServiceFree(Integer idc) {
        return contractRepository.getAttachServiceFree(idc);
    }

    @Override
    public Page<Contract> getCustomerPresent(Pageable pageable) {
        LocalDate now = LocalDate.now();
        return contractRepositoryNew.findAllByEndDateAfter(now,pageable);
    }
}
