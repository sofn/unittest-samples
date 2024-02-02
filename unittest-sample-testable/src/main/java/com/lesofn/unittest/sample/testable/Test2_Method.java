package com.lesofn.unittest.sample.testable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sofn
 * @date 2022-05-18 20:14
 */
public class Test2_Method {


    public String partString(int s, int e) {
        return "hello".substring(s, e);
    }

    public String trim() {
        return "hello".trim();
    }

    public String param() {
        return "param";
    }

    public String paramCall() {
        return this.param();
    }

    public static String staticMethod() {
        return "staticMethod";
    }

    /**
     * method with static method invoke
     */
    public String getStaticMethod() {
        return Test2_Method.staticMethod();
    }

    public MockNew createMockNew(String name) {
        return new MockNew(name);
    }

    @Data
    @AllArgsConstructor
    public static class MockNew {
        private String name;
    }

}
