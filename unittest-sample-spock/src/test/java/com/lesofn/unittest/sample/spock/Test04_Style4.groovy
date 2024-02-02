package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 风格: expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test04_Style4 extends Specification {

    static def calculator

    //在所有测试方法执行之前调用一次
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // 测试方法
    def "test plus"() {
        expect: "测试方法"
        3 == calculator.add(1, 2)
    }
}
