package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * style: expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test04_Style4 extends Specification {

    static def calculator

    //called once before all test methods are executed
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // call test method
    def "test plus"() {
        expect: "call test method"
        3 == calculator.add(1, 2)
    }
}
