package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockWith;
import com.alibaba.testable.core.model.ClassType;
import com.lesofn.unittest.sample.testable.infrastructure.BasicServiceMock;

import org.junit.jupiter.api.Test;

/**
 * 如果mock其他类 必须放到${TargetClass}Test类里
 *
 * @author sofn
 * @date 2022-05-19 15:21
 */
@MockWith(value = BasicServiceMock.class, treatAs = ClassType.TestClass)
class Test5_GlobalServiceTest {

    Test5_GlobalService service = new Test5_GlobalService();

    @Test
    void testSet() {
        System.out.println(service.get("key"));
    }

}