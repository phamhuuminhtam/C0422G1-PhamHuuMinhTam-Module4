package com.email.repository.impl;

import com.email.model.Language;
import com.email.repository.LanguageRopository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LanguageRopositoryImpl implements LanguageRopository {
   private static List<Language> languageList = new ArrayList<>();
    static {
        languageList.add(new Language("English"));
        languageList.add(new Language("Vietnamese"));
        languageList.add(new Language("Japanese"));
        languageList.add(new Language("Chinese"));
    }
    @Override
    public List<Language> findAll() {
        return languageList;
    }
}
