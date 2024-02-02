package com.lesofn.unittest.sample.testable.mock;

import com.alibaba.testable.core.annotation.MockInvoke;
import com.lesofn.unittest.sample.testable.TestableService;

/**
 * @author sofn
 * @date 2022-05-18 20:24
 */
public class ServiceMock {

    @MockInvoke(targetClass = TestableService.class)
    private String privateMethod(String str) {
        System.out.println("mock-annotation");
        return "mock-string";
    }
}
