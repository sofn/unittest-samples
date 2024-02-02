package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.tool.PrivateAccessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 如果mock其他类 需要放到${TargetClass}Test类里
 *
 * @author sofn
 * @date 2022-05-18 16:05
 */
public class Test3_PrivateField {

    TestableService service = new TestableService();

    @Test
    public void should_mock_private_field() {
        PrivateAccessor.set(service, "num", 10);
        assertEquals(10, (int) PrivateAccessor.get(service, "num"));
    }

}
