package com.furama.service.contract;

import com.furama.dto.ContractDto;
import com.furama.dto.ContractPageDto;
import com.furama.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<ContractDto> showContract() {
        return contractRepository.showContract();
    }

    @Override
    public Page<ContractPageDto> getContractPage(Pageable pageable) {
        return contractRepository.getContractPage(pageable);
    }
}
