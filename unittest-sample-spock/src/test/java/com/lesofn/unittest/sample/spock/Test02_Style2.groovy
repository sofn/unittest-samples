package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 风格: given … when … then …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test02_Style2 extends Specification {

    static def calculator

    //在所有测试方法执行之前调用一次
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // 测试方法
    def "test plus 1"() {
        // given可以省略
        given: "准备数据"
        def a = 1
        def b = 2

        when: "测试方法"
        def c = calculator.add(a, b)

        then: "校验结果"
        c == 3
    }

    def "test minus 1"() {
        given: "准备数据"
        def a = 1
        def b = 2

        when: "测试方法"
        def c = calculator.add(a, b)

        then: "校验结果"
        c == 4 - 1
    }
}
