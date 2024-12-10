package com.lesofn.unittest.sample.spring.test4_mockbean;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;

/**
 * @MockBean 只能 mock 本地的代码——或者说是自己写的代码，对于储存在库中而且又是以 Bean 的形式装配到代码中的类无能为力。
 *
 * @SpyBean 解决了 SpringBoot 的单元测试中 @MockBean 不能 mock 库中自动装配的 Bean 的局限（目前还没需求，有需要的自己查阅资料）。
 *
 * @author sofn
 * @since 2022-05-20 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(classes = {SpringMockBeanTest.SpringAnnoBase.class})
public class SpringMockBeanTest {

    @Configuration
    @ComponentScan({"com.lesofn.unittest.sample.spring.test4_mockbean"})
    public static class SpringAnnoBase {
    }

    @MockBean
    private ActionMapper actionMapper;

    @Resource
    @InjectMocks
    private ActionServiceMockBean service;

    /**
     * 因为已经有@RunWith注解了 需要用这种方式初始化mockito
     */
    @Before
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRead() {
        when(actionMapper.queryFirst()).thenReturn(new Action());
        Action action = service.queryFirst();
        System.out.println(action);
    }

}
