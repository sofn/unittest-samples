package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockDiagnose;
import com.alibaba.testable.core.annotation.MockInvoke;
import com.alibaba.testable.core.annotation.MockNew;
import com.alibaba.testable.core.model.LogLevel;
import org.junit.jupiter.api.Test;

import static com.alibaba.testable.core.matcher.InvocationVerifier.verifyInvoked;
import static com.alibaba.testable.core.tool.TestableTool.MOCK_CONTEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 如果mock其他类 需要放到${TargetClass}Test类里
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
public class Test2_MethodTest {

    private Test2_Method service = new Test2_Method();

    /**
     *  @MockDiagnose 注解调整日志级别
     */
    @MockDiagnose(LogLevel.DISABLE)
    public static class Mock {
        /**
         * 默认方法名是和被mock的类方法名一致
         */
        @MockInvoke(targetClass = String.class)
        private String trim() {
            return "trim_string";
        }

        /**
         * 如果方法名不一致需要指定
         */
        @MockInvoke(targetClass = String.class, targetMethod = "substring")
        private String sub(int i, int j) {
            return "sub_string";
        }

        @MockNew
        private Test2_Method.MockNew createMockNew(String name) {
            return new Test2_Method.MockNew("mock-name");
        }

        @MockInvoke(targetClass = Test2_Method.class)
        public String staticMethod() {
            return "MOCK_STATIC";
        }

        @MockInvoke(targetClass = Test2_Method.class)
        public String param() {
            if ("param1".equals(MOCK_CONTEXT.get("param"))) {
                return "param1_result";
            }
            return "mock_result";
        }
    }

    @Test
    public void should_mock_common_method() {
        assertEquals("sub_string", service.partString(1, 200));
        verifyInvoked("sub").withTimes(1);

        assertEquals("trim_string", service.trim());
        verifyInvoked("trim").withTimes(1);
    }

    @Test
    public void should_mock_new_object() {
        assertEquals("mock-name", service.createMockNew("tom").getName());
        verifyInvoked("createMockNew").with("tom");
    }

    /**
     * 注意不能在测试类里直接调用静态方法，只能调用被测对象里的方法间接调用
     */
    @Test
    public void should_mock_static_method() {
        assertEquals("MOCK_STATIC", service.getStaticMethod());
        verifyInvoked("staticMethod").withTimes(1);
    }

    @Test
    public void should_set_mock_context() {
        MOCK_CONTEXT.put("param", "param1");
        assertEquals("param1_result", service.paramCall());

        MOCK_CONTEXT.put("param", "param2");
        assertEquals("mock_result", service.paramCall());
    }
}
