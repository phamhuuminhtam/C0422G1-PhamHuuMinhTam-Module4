package com.email.service.impl;

import com.email.model.PageSize;
import com.email.repository.PageSizeRepository;
import com.email.service.PageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageSizeServiceImpl implements PageSizeService {

    @Autowired
    private PageSizeRepository pageSizeRepository;
    @Override
    public List<PageSize> findAll() {
        return pageSizeRepository.findAll();
    }
}
