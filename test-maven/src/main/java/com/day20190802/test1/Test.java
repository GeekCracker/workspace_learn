package com.day20190802.test1;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal(10);
        BigDecimal bigDecimal2 = new BigDecimal(9);

        System.out.println(bigDecimal1.compareTo(bigDecimal2));
    }
}
