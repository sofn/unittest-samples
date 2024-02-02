package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 风格: given … expect … where …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test03_Style3 extends Specification {

    static def calculator

    //在所有测试方法执行之前调用一次
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    // where 风格1
    def "test plus"() {
        // given 可以省略
        given: "准备数据"

        expect: "测试方法"
        z == calculator.add(x, y)

        where: "校验结果"
        x | y || z
        1 | 0 || 1
        2 | 1 || 3
        2 | 3 || 5
    }

    // where 风格2
    def "length of Yawn's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name << ["Yawn", "Tim"]
        length << [4, 3]
    }
}
