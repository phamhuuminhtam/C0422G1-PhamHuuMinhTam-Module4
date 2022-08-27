package com.furama.service.education.impl;

import com.furama.model.EducationDegree;
import com.furama.repository.EducationDegreeRepository;
import com.furama.service.education.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;


    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
