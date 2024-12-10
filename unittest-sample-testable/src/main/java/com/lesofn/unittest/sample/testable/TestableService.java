package com.lesofn.unittest.sample.testable;

/**
 * @author sofn
 * @since 2022-05-18 20:14
 */
public class TestableService {

    private Integer num;

    public String publicMethod(String str) {
        System.out.println("publicMethod:" + str);
        return privateMethod(str);
    }

    private String privateMethod(String str) {
        System.out.println("privateMethod:" + str);
        return str;
    }


}
