package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * Advanced mocking techniques
 * @author sofn
 * @since 2024-04-22 22:52
 */
class Test11_AdvancedMocking extends Specification {

    def "test sequential responses"() {
        given:
        def calculator = Mock(Calculator)
        calculator.add(1, 1) >>> [2, 3, 4]

        expect:
        calculator.add(1, 1) == 2
        calculator.add(1, 1) == 3
        calculator.add(1, 1) == 4
        // Will return the last value for any additional calls
        calculator.add(1, 1) == 4
    }

    def "test conditional responses"() {
        given:
        def calculator = Mock(Calculator)
        calculator.add(_, _) >> { int a, int b -> a > b ? a : b }

        expect:
        calculator.add(5, 3) == 5
        calculator.add(2, 7) == 7
        calculator.add(4, 4) == 4
    }

    def "test interaction verification"() {
        given:
        def calculator = Mock(Calculator)

        when:
        calculator.add(1, 2)
        calculator.add(3, 4)
        calculator.subtract(5, 3)

        then:
        2 * calculator.add(_, _) // Verify add was called exactly twice
        1 * calculator.subtract(5, _) // Verify subtract was called once with first arg = 5
        0 * calculator.divide(_, _) // Verify divide was never called
    }

    def "test call ordering"() {
        given:
        def calculator = Mock(Calculator)

        when:
        calculator.add(1, 2)
        calculator.subtract(5, 3)
        calculator.multiply(2, 3)

        then:
        1 * calculator.add(_, _)
        then:
        1 * calculator.subtract(_, _)
        then:
        1 * calculator.multiply(_, _)
    }
}
