package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.annotation.MockWith;
import com.alibaba.testable.core.model.ClassType;
import com.lesofn.unittest.sample.testable.infrastructure.BasicServiceMock;

import org.junit.jupiter.api.Test;

/**
 * If you mock other classes, you must put them in the ${TargetClass}Test class
 *
 * @author sofn
 * @since 2022-05-19 15:21
 */
@MockWith(value = BasicServiceMock.class, treatAs = ClassType.TestClass)
class Test5_GlobalServiceTest {

    Test5_GlobalService service = new Test5_GlobalService();

    @Test
    void testSet() {
        System.out.println(service.get("key"));
    }

}