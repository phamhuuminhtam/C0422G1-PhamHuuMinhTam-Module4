package com.calculator.service.impl;

import com.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String solve(String numb1, String numb2, String action) {
        double num1 = Double.parseDouble(numb1);
        double num2 = Double.parseDouble(numb2);
        String result="";
        switch (action){
            case "+":
                result=(num1+num2)+"";
                break;
            case "-":
                result=(num1-num2)+"";
                break;
            case "*":
                result=(num1*num2)+"";
                break;
            case "/":
                if(num2==0){
                    result ="cant div 0";
                }else
                    result=(num1/num2)+"";
                break;
        }
        return result;
    }
}
