package com.day20191005.test1;

import jdk.nashorn.internal.runtime.linker.Bootstrap;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test1 {
    private static volatile Integer count = 0;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        unsafe.fullFence();
        count++;
        System.out.println(count);
    }
}
