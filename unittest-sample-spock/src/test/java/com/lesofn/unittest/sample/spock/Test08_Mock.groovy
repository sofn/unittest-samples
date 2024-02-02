package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 多次执行语句
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test08_Mock extends Specification {

    def calculator = Mock(Calculator)

    def "test addition with mock"() {
        given:
        calculator.add(1, 2) >> 4
        calculator.subtract(_, _) >> 10

        when:
        def result = calculator.add(1, 2)
        def result2 = calculator.subtract(2, 1)

        println result2

        then:
        result == 4
        result2 == 10

    }
}
