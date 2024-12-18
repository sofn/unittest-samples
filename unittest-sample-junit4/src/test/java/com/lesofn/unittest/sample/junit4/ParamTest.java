package com.lesofn.unittest.sample.junit4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.lesofn.unittest.common.Fibonacci;


/**
 * Multi-parameter testing
 *
 * @author sofn
 * @since 2022-05-17 17:56
 */
@RunWith(Parameterized.class)
public class ParamTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}});
    }

    /**
     * first param, default 0
     * method must not be private
     */
    @Parameterized.Parameter
    public int input;

    /**
     * second param
     * method must not be private
     */
    @Parameterized.Parameter(1)
    public int expected;

    @Test
    public void test() {
        Assert.assertEquals(expected, Fibonacci.fibonacci(input));
    }
}
