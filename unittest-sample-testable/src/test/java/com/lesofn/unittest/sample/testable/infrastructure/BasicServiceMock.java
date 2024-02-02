package com.lesofn.unittest.sample.testable.infrastructure;

import com.alibaba.testable.core.annotation.MockInvoke;

/**
 * @author sofn
 * @date 2022-05-19 15:21
 */
public class BasicServiceMock {

    @MockInvoke(targetClass = BasicService.class)
    public String get(String key)  {
        return "mock-get:" + key;
    }

    @MockInvoke(targetClass = BasicService.class)
    public void set(String key, String value) {
        System.out.println("mock-set:" + key + "-" + value);
    }

}