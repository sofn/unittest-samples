package com.lesofn.unittest.sample.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author sofn
 * @date 2022-05-17 17:56
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @Test
    @Order(1)
    public void test1() {
        System.out.println("run test1");
    }

    @Test
    @Order(2)
    public void test2() {
        System.out.println("run test2");
    }

    @Test
    @Order(3)
    public void test3() {
        System.out.println("run test3");
    }
}
