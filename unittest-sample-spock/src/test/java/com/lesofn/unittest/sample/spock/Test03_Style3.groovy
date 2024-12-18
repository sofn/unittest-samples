package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * style: given … expect … where …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test03_Style3 extends Specification {

    static def calculator

    //called once before all test methods are executed
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // where style1
    def "test plus"() {
        // given 可以省略
        given: "prepare"

        expect: "call test method"
        z == calculator.add(x, y)

        where: "verity result"
        x | y || z
        1 | 0 || 1
        2 | 1 || 3
        2 | 3 || 5
    }

    // where style2
    def "length of Yawn's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name << ["Yawn", "Tim"]
        length << [4, 3]
    }
}
