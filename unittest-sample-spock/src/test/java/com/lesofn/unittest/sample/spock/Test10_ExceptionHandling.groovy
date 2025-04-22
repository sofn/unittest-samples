package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * Exception handling in Spock tests
 * @author sofn
 * @since 2024-04-22 22:52
 */
class Test10_ExceptionHandling extends Specification {

    def calculator = new Calculator()

    def "test divide by zero throws exception"() {
        when:
        calculator.divide(10, 0)

        then:
        def exception = thrown(ArithmeticException)
        exception.message == "/ by zero"
    }

    def "test exception with message"() {
        when:
        throw new IllegalArgumentException("Invalid argument")

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Invalid argument"
    }

    def "test no exception is thrown"() {
        when:
        def result = calculator.divide(10, 2)

        then:
        notThrown(ArithmeticException)
        result == 5
    }
}
