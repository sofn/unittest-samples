package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * execute statements multiple times
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test07_RunMulti extends Specification {

    static def calculator

    //called once before all test methods are executed
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    def "execute statements multiple times"() {
        given:
        def a = 2

        // 执行3次后结果为 3
        expect: "aaa"
        3.times { a++ }
        a == 5
    }
}
