package com.lesofn.unittest.sample.junit4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lesofn.unittest.common.Calculator;

/**
 * @author sofn
 * @since 2024-02-01 16:09
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals("2 + 3 应该等于 5", 5, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals("5 - 3 应该等于 2", 2, result);
    }

}