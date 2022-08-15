package com.dictionary.repository.impl;

import com.dictionary.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Service
public class DictionaryRepositoryImpl implements DictionaryRepository {
    static private Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("table","cái bàn");
        dictionary.put("chair","cái ghế");
        dictionary.put("pen","cây bút");
        dictionary.put("pencil","bút chì");
        dictionary.put("win","thắng");
        dictionary.put("hat","cái mũ");

    }

    @Override
    public String translate(String word) {
        String result="";
        Set<String> stringSet = dictionary.keySet();
        for(String s: stringSet){
            if (word.equalsIgnoreCase(s)){
                result=dictionary.get(s);
            }
        }
        if (result==""){
            result="Không tìm thấy!";
        }
        return  result;
    }
}
