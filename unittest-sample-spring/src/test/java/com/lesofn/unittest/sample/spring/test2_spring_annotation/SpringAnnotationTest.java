package com.lesofn.unittest.sample.spring.test2_spring_annotation;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNull;

/**
 * @author sofn
 * @since 2022-05-19 21:22
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(classes = {SpringAnnoBase.class})
public class SpringAnnotationTest {

    @Resource
    private ActionMapper actionMapper;

    @Test
    public void selectAction() {
        Action action = actionMapper.queryFirst();
        assertNull(action);
    }


}