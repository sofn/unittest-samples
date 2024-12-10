package com.lesofn.unittest.sample.testable;

import org.junit.jupiter.api.Test;

import static com.alibaba.testable.core.matcher.InvocationVerifier.verifyInvoked;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 独立类 使用TestableServiceMock中的mock
 * 规则：在测试类相同包路径下创建一个类，类名为被测试类名+Mock
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
public class Test1_Mock2_TargetClassMock {

    @Test
    public void should_mock_method() {
        TestableService service = new TestableService();
        assertEquals("mock-string", service.publicMethod("hello"));
        verifyInvoked("privateMethod").with("hello");
    }

}
