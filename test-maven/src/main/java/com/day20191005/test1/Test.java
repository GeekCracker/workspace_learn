package com.day20191005.test1;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> as = new ArrayList<String>();

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("a");
        ll.add("b");
        ll.add(null);
        ll.add(null);
        ll.add(null);
        ll.add(null);
        ll.add(null);
        System.out.println(ll.size());
        ll.remove(null);
        ll.remove(1);
//        ll.removeAll()
        System.out.println(ll.size());
        System.out.println(ll.iterator());

        Vector vector = new Vector();
        Unsafe unsafe = Unsafe.getUnsafe();
        vector.removeAllElements();
        System.out.println(~-3);
    }
}
