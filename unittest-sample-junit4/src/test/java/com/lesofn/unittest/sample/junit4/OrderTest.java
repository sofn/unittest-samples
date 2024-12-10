package com.lesofn.unittest.sample.junit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * MethodSorters.NAME_ASCENDING: order by method name asc
 *
 * @author sofn
 * @since 2022-05-17 17:56
 */
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class OrderTest {

    @Test
    public void test1() {
        System.out.println("run test1");
    }

    @Test
    public void test2() {
        System.out.println("run test2");
    }

    @Test
    public void test3() {
        System.out.println("run test3");
    }
}
