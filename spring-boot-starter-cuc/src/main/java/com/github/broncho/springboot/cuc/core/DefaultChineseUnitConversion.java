package com.github.broncho.springboot.cuc.core;

import com.github.broncho.springboot.cuc.ChineseUnitConversion;
import com.github.broncho.springboot.cuc.autoconfigure.CucProperties;

import java.text.DecimalFormat;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
public class DefaultChineseUnitConversion implements ChineseUnitConversion {
    
    private CucProperties properties;
    
    private String pattern;
    
    public DefaultChineseUnitConversion(CucProperties properties) {
        this.properties = properties;
        if (this.properties.getEnableMoneyPattern()) {
            pattern = "##,###,00";
        } else {
            pattern = "%." + properties.getPrecision() + "f";
        }
    }
    
    @Override
    public String cuc(long value) {
        CucProperties.Unit[] units = properties.units();
        DecimalFormat format = new DecimalFormat();
        String result;
        for (CucProperties.Unit u : units) {
            if (value / u.getValue() > 1) {
                if (this.properties.getEnableMoneyPattern()) {
                    format.applyPattern(pattern);
                    result = format.format(value / u.getValue());
                } else {
                    result = String.format(pattern, value / (u.getValue() * 1.00));
                }
                return result + u.getName();
            }
        }
        return String.valueOf(value);
    }
}
