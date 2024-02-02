package com.lesofn.unittest.sample.testable;

import java.util.List;

/**
 * @author sofn
 * @date 2022-05-17 21:08
 */
public class MyService {

    public List<String> list;

    public boolean add(String str) {
        return list.add(str);
    }

    public String get(int index) {
        return list.get(index);
    }

    public int numAdd(int a, int b) {
        System.out.println("input: " + a + "," + b);
        return a + b;
    }
}
