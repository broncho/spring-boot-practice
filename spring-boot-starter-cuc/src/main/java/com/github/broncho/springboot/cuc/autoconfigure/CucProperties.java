package com.github.broncho.springboot.cuc.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@ConfigurationProperties(prefix = "cuc")
public class CucProperties {
    
    /**
     * 精度，默认2
     */
    private Integer precision = 2;
    
    /**
     * 金额模式，默认不开启
     */
    private Boolean enableMoneyPattern = Boolean.FALSE;
    
    /**
     * 单位列表
     */
    private List<String> unitPair = new ArrayList<String>();
    
    private final Unit[] defaultUnit = new Unit[]{
            new Unit(100000000L, "亿"),
            new Unit(1000000L, "百万"),
            new Unit(10000L, "万"),
            new Unit(1000L, "千"),
    };
    
    private Unit[] units = defaultUnit;
    
    public Integer getPrecision() {
        return precision;
    }
    
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
    
    @PostConstruct
    protected void init() {
        if (unitPair.isEmpty()) {
            return;
        }
        List<Unit> defined = new ArrayList<Unit>();
        for (String item : unitPair) {
            item = item.trim();
            int index = item.indexOf(":");
            if (index == -1) {
                throw new RuntimeException("unitPair format exception please set value:name eg: 1000:千");
            }
            String v = item.substring(0, index).trim();
            if (v.isEmpty()) {
                throw new RuntimeException("unitPair format exception value is empty please set value:name eg: 1000:千");
            }
            try {
                String name = item.substring(index + 1).trim();
                if (name.isEmpty()) {
                    throw new RuntimeException("unitPair format exception name is empty please set value:name eg: 1000:千");
                }
                long value = Long.parseLong(v);
                Unit u = new Unit(value, name);
                if (defined.contains(u)) {
                    throw new RuntimeException(String.format("unitPair %d:%s duplicate defined", value, name));
                } else {
                    defined.add(u);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException("unitPair format exception name is empty please set value:name eg: 1000:千");
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        String.format("unitPair format exception value format error %s please set value:name eg: 1000:千", e.getMessage()));
            }
        }
        Collections.sort(defined, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        this.units = new Unit[defined.size()];
        for (int i = 0, len = defined.size(); i < len; i++) {
            this.units[i] = defined.get(i);
        }
    }
    
    public Unit[] units() {
        return this.units;
    }
    
    
    public List<String> getUnitPair() {
        return unitPair;
    }
    
    public void setUnitPair(List<String> unitPair) {
        this.unitPair = unitPair;
    }
    
    public Boolean getEnableMoneyPattern() {
        return enableMoneyPattern;
    }
    
    public void setEnableMoneyPattern(Boolean enableMoneyPattern) {
        this.enableMoneyPattern = enableMoneyPattern;
    }
    
    public static class Unit {
        
        private long value;
        
        private String name;
        
        public Unit() {
        }
        
        public Unit(long value, String name) {
            this.value = value;
            this.name = name;
        }
        
        public long getValue() {
            return value;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Unit unit = (Unit) o;
            
            if (value != unit.value) return false;
            return name.equals(unit.name);
            
        }
        
        @Override
        public int hashCode() {
            int result = (int) (value ^ (value >>> 32));
            result = 31 * result + name.hashCode();
            return result;
        }
    }
}
