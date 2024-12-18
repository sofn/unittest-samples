package com.lesofn.unittest.sample.spock

import com.lesofn.unittest.common.Calculator
import spock.lang.Specification

/**
 * style：given … expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test01_Style1 extends Specification {

    static def calculator

    /**
     * called once before all test methods are executed
     */
    def setupSpec() {
        calculator = new Calculator()
        println ">>>>>>   setupSpec"
    }

    /**
     * called before each test method is executed
     */
    def setup() {
        println ">>>>>>   setup"
    }

    /**
     * called after each test method is executed
     */
    def cleanup() {
        println ">>>>>>   cleanup"
    }

    /**
     * called once after all test method is executed
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
