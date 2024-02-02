package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 风格: expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test05_VerifyAll extends Specification {

    static def calculator

    //在所有测试方法执行之前调用一次
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    def "没有参数的 verifyAll"() {
        when:
        int z1 = calculator.add(1, 1)
        int z2 = calculator.add(1, 2)
        int z3 = calculator.add(1, 3)

        then:
        verifyAll {
            z1 == 2
            z2 == 3
            z3 == 4
        }
    }
}
