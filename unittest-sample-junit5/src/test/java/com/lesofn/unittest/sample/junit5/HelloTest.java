package com.lesofn.unittest.sample.junit5;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author sofn
 * @since 2022-05-17 17:56
 */
public class HelloTest {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("The HelloTest class is executed first and only once.");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("Executed after the HelloTest class is executed, only once");
    }

    @BeforeEach
    public void before() {
        System.out.println("Executed before each @Test method is executed");
    }

    /**
     * general
     */
    @Test
    public void test() {
        System.out.println("run test");
    }

    /**
     * assert
     */
    @Test
    public void assertTest() {
        int res = 1 + 1;
        assertEquals(2, res);
    }

    /**
     * exception
     */
    @Test
    public void testError() {
        assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("error");
        });
    }

    @AfterEach
    public void after() {
        System.out.println("Executed after each @Test method is executed");
    }
}
