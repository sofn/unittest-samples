package com.lesofn.unittest.sample.spring.test3_mockito;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;

/**
 * 需要设置： @Autowired(required = false)
 *
 * @author sofn
 * @date 2022-05-20 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(classes = {SpringMockitoTest.SpringAnnoBase.class})
public class SpringMockitoTest {

    @Configuration
    @ComponentScan({"com.lesofn.unittest.sample.spring.test3_mockito"})
    public static class SpringAnnoBase {
    }

    @Mock
    private ActionMapper actionMapper;

    @Resource
    @InjectMocks
    private ActionService service;

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
