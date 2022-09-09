package com.furama.service.contract;

import com.furama.dto.ContractDto;
import com.furama.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
