package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockWith;
import com.alibaba.testable.core.model.ClassType;
import com.lesofn.unittest.sample.testable.mock.ServiceMock;

import org.junit.jupiter.api.Test;

import static com.alibaba.testable.core.matcher.InvocationVerifier.verifyInvoked;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 注解类
 * 规则：在任意包路径下创建一个类，类名随意，在测试类中使用注解声明Mock类
 * <p>
 * \ @MockWith默认使用被注解类名字的尾缀判断当前类是被测类（名字非Test结尾）还是测试类（名字Test结尾），
 * 若遇到不符合此规则的类型，应使用注解的treatAs参数显式的指定（ClassType.SourceClass-被测类/ClassType.TestClass-测试类）
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
@MockWith(value = ServiceMock.class, treatAs = ClassType.TestClass)
class Test1_Mock3_Annotation {

    private TestableService service = new TestableService();

    @Test
    public void should_mock_method() {
        assertEquals("mock-string", service.publicMethod("hello"));
        verifyInvoked("privateMethod").with("hello");
    }

}
