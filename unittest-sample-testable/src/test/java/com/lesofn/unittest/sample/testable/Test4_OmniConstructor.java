package com.lesofn.unittest.sample.testable;

import com.alibaba.testable.core.tool.OmniAccessor;
import com.alibaba.testable.core.tool.OmniConstructor;
import com.alibaba.testable.core.tool.PrivateAccessor;
import org.junit.jupiter.api.Test;

/**
 * 文档: https://alibaba.github.io/testable-mock/#/zh-cn/doc/omni-constructor
 *
 * @author sofn
 * @since 2022-05-18 16:05
 */
public class Test4_OmniConstructor {

    @Test
    public void should_omni_constructor() {
        TestableService service = OmniConstructor.newInstance(TestableService.class);
        System.out.println((int) PrivateAccessor.get(service, "num"));

        System.out.println((int) OmniAccessor.get(service, "num").get(0));
    }

}
