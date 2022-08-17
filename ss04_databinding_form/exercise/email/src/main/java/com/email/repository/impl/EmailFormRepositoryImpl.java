package com.email.repository.impl;

import com.email.model.EmailForm;
import com.email.repository.EmailFormRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailFormRepositoryImpl implements EmailFormRepository {
    private static List<EmailForm> emailFormList = new ArrayList<>();
    @Override
    public void saveMail(EmailForm emailForm) {
        emailFormList.add(emailForm);

    }
}
