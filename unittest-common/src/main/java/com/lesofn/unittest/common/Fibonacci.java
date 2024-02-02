package com.lesofn.unittest.common;

/**
 * 斐波那契
 *
 * @author sofn
 * @date 2022-05-17 18:13
 */
public class Fibonacci {

    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
