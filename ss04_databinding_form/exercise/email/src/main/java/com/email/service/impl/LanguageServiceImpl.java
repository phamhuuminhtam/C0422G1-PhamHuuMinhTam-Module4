package com.email.service.impl;

import com.email.model.Language;
import com.email.repository.LanguageRopository;
import com.email.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRopository languageRopository;

    @Override
    public List<Language> findAll() {
        return languageRopository.findAll();
    }
}
