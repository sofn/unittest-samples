package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Data-driven testing with where blocks
 * @author sofn
 * @since 2024-04-22 22:52
 */
class Test09_DataDriven extends Specification {

    def calculator = new Calculator()

    def "test addition with various inputs"() {
        expect:
        calculator.add(a, b) == result

        where:
        a | b || result
        1 | 2 || 3
        5 | 5 || 10
        0 | 0 || 0
        -1 | 1 || 0
    }

    @Unroll
    def "#a plus #b should equal #result"() {
        expect:
        calculator.add(a, b) == result

        where:
        a | b || result
        1 | 2 || 3
        5 | 5 || 10
        0 | 0 || 0
        -1 | 1 || 0
    }

    def "test with data tables"() {
        expect:
        calculator.subtract(a, b) == result

        where:
        a | b || result
        5 | 2 || 3
        10 | 5 || 5
        0 | 0 || 0
        1 | 2 || -1
    }
}
