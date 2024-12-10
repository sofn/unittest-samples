package com.lesofn.unittest.sample.junit4;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author sofn
 * @since 2022-05-17 17:56
 */
public class HelloTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("The HelloTest class is executed first and only once.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Executed after the HelloTest class is executed, only once");
    }

    @Before
    public void before() {
        System.out.println("Executed before each @Test method is executed");
    }

    /**
     * Normal test methods must be public
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
    @Test(expected = RuntimeException.class)
    public void testError() {
        throw new RuntimeException("error");
    }

    @After
    public void after() {
        System.out.println("Executed after each @Test method is executed");
    }
}
