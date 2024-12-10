package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockInvoke;

/**
 * @author sofn
 * @since 2022-05-18 20:54
 */
public class TestableServiceMock {

    @MockInvoke(targetClass = TestableService.class)
    private String privateMethod(String str) {
        System.out.println("mock-targetClass");
        return "mock-string";
    }

}