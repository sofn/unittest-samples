package com.lesofn.unittest.sample.spock


import spock.lang.Specification

/**
 * 风格: expect …
 * @author sofn
 * @since 2024-02-01 19:16
 */
class Test06_WithVerifyAll extends Specification {

    def "test person use with(p)"() {
        given: "init a person"
        Date now = new Date()
        Person p = new Person(name: "yawn", age: 18, birthday:   now)

        expect: "测试p"
        with(p) {
            name == "yawn"
            age < 20
            birthday == now
        }
    }

    def "多个预期值的测试使用 verifyAll()"() {
        when:
        Person p = new Person(name: "yawn", age: 18)

        then:
        verifyAll(p) {
            name == "yawn"
            age < 20
        }
    }

    static class Person {
        private String name
        private int age
        private Date birthday
    }
}
