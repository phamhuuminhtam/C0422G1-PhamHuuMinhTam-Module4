package com.furama.service.contractdetail;

import com.furama.model.ContractDetail;
import com.furama.repository.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements ContractDetailService{
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public void save(List<ContractDetail> contractDetailList) {
        contractDetailRepository.saveAll(contractDetailList);
    }
}
