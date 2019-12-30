package com.day20191212.test1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Set<Integer> set1 = new LinkedHashSet<Integer>();
        set1.add(200);
        set1.add(233);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(400);
        set2.add(300);
        set1.retainAll(set2);
        System.out.println(set1);

    }
}
