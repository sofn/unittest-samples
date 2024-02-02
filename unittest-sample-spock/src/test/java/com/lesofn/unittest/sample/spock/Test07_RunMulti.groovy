package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 多次执行语句
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test07_RunMulti extends Specification {

    static def calculator

    //在所有测试方法执行之前调用一次
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    def "多次执行测试语句"() {
        given:
        def a = 2

        // 执行3次后结果为 3
        expect: "aaa"
        3.times { a++ }
        a == 5
    }
}
