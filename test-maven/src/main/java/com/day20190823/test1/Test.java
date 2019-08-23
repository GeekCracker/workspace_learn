package com.day20190823.test1;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("100.00");
        BigDecimal bigDecimal2 = new BigDecimal("100.00");
        System.out.println(bigDecimal1.equals(bigDecimal2));
    }
}
