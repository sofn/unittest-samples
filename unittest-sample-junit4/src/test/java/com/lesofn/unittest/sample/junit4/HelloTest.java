package com.lesofn.unittest.sample.junit4;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author sofn
 * @date 2022-05-17 17:56
 */
public class HelloTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("HelloTest类开始最先执行，只执行一次");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("HelloTest类执行完后执行，只执行一次");
    }

    @Before
    public void before() {
        System.out.println("每个@Test方法执行前执行");
    }

    /**
     * 普通 测试方法 必须是public
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
    @Test(expected = RuntimeException.class)
    public void testError() {
        throw new RuntimeException("error");
    }

    @After
    public void after() {
        System.out.println("每个@Test方法执行后执行");
    }
}
