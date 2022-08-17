package com.email.service.impl;

import com.email.model.EmailForm;
import com.email.repository.EmailFormRepository;
import com.email.service.EmailFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailFormServiceImpl implements EmailFormService {
    @Autowired
    private EmailFormRepository emailFormRepository;
    @Override
    public void saveMail(EmailForm emailForm) {
        emailFormRepository.saveMail(emailForm);
    }
}
