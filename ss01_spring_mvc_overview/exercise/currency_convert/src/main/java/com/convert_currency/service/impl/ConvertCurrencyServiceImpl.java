package com.convert_currency.service.impl;

import com.convert_currency.service.ConvertCurrencySerivce;
import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyServiceImpl implements ConvertCurrencySerivce {
    @Override
    public double convertCurrency(double usd, double rate) {
        return rate*usd ;
    }
}
