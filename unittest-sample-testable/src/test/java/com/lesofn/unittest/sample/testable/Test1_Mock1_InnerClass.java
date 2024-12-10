package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockInvoke;

import org.junit.jupiter.api.Test;

import static com.alibaba.testable.core.matcher.InvocationVerifier.verifyInvoked;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 内部类形式mock
 * 规则：在测试类中创建一个静态内部类，类名必须为Mock
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
public class Test1_Mock1_InnerClass {

    public static class Mock {
        @MockInvoke(targetClass = TestableService.class)
        private String privateMethod(String str) {
            System.out.println("mock-innerClass");
            return "mock-string";
        }
    }

    @Test
    public void should_mock_method() {
        TestableService service = new TestableService();
        assertEquals("mock-string", service.publicMethod("hello"));
        verifyInvoked("privateMethod").with("hello");
    }

}
