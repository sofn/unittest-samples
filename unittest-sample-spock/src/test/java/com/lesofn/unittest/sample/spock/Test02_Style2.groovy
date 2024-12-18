package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * style: given … when … then …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test02_Style2 extends Specification {

    static def calculator

    //called once before all test methods are executed
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // test method
    def "test plus 1"() {
        given: "prepare"
        def a = 1
        def b = 2

        when: "call test method"
        def c = calculator.add(a, b)

        then: "verity result"
        c == 3
    }

    def "test minus 1"() {
        given: "prepare"
        def a = 1
        def b = 2

        when: "call test method"
        def c = calculator.add(a, b)

        then: "verity result"
        c == 4 - 1
    }
}
