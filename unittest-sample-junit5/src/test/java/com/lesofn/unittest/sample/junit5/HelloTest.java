package com.lesofn.unittest.sample.junit5;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author sofn
 * @date 2022-05-17 17:56
 */
public class HelloTest {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("HelloTest类开始最先执行，只执行一次");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("HelloTest类执行完后执行，只执行一次");
    }

    @BeforeEach
    public void before() {
        System.out.println("每个@Test方法执行前执行");
    }

    /**
     * 普通
     */
    @Test
    public void test() {
        System.out.println("run test");
    }

    /**
     * 断言
     */
    @Test
    public void assertTest() {
        int res = 1 + 1;
        assertEquals(2, res);
    }

    /**
     * 异常
     */
    @Test
    public void testError() {
        assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("error");
        });
    }

    @AfterEach
    public void after() {
        System.out.println("每个@Test方法执行后执行");
    }
}
