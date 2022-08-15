package com.dictionary.service.impl;

import com.dictionary.repository.DictionaryRepository;
import com.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
@Autowired
private DictionaryRepository dictionaryRepository;
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
