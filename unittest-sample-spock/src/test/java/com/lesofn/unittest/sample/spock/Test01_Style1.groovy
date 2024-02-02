package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * 风格：given … expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test01_Style1 extends Specification {

    static def calculator

    /**
     * 在所有测试方法执行之前调用一次
     */
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    /**
     * 在每个测试方法执行之前调用
     */
    def setup() {
        println ">>>>>>   setup"
    }

    /**
     * 在每个测试方法执行之后调用一次
     */
    def cleanup() {
        println ">>>>>>   cleanup"
    }

    /**
     * 在所有测试方法执行之后调用一次
     */
    def cleanupSpec() {
        println ">>>>>>   cleanupSpec"
    }

    def "test life cycle"() {
        given:
        def a = 1
        def b = 2

        expect:
        a < b

        println "test method finished!"
    }

    def "test calculator.add"() {
        given:
        def a = 1
        def b = 2

        expect:
        calculator.add(a, b) == 3
        println "test calculator.add finished!"
    }
}
