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
 * If you want to mock other classes, you need to put them in the ${TargetClass}Test class
 * <p>
 * If you want to mock other classes, you need to put them in the ${TargetClass}Test class
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
public class Test2_MethodTest {

    private Test2_Method service = new Test2_Method();

    /**
     *  @MockDiagnose change log level
     */
    @MockDiagnose(LogLevel.DISABLE)
    public static class Mock {
        /**
         * The default method name is the same as the mocked class method name.
         */
        @MockInvoke(targetClass = String.class)
        private String trim() {
            return "trim_string";
        }

        /**
         * If the method name is inconsistent, you need to specify
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
     * Note that you cannot call static methods directly in the test class,
     * you can only call them indirectly by calling methods in the object being tested.
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
