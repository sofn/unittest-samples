package com.lesofn.unittest.sample.spring.test5_testable;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.testable.core.annotation.MockInvoke;
import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;

/**
 * @author sofn
 * @date 2022-05-20 14:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ActionServiceTestableTest.SpringAnnoBase.class})
public class ActionServiceTestableTest {

    @Configuration
    @ComponentScan({"com.lesofn.unittest.sample.spring.test5_testable"})
    public static class SpringAnnoBase {
    }

    public static class Mock {
        @MockInvoke(targetClass = ActionMapper.class)
        public Action queryFirst() {
            System.out.println("mock-innerClass");
            Action action = new Action();
            action.setActionType(Integer.MAX_VALUE);
            return action;
        }
    }

    @MockBean
    private ActionMapper actionMapper;

    @Resource
    private ActionServiceTestable service;

    @Test
    public void testRead() {
        Action action = service.queryFirst();
        assertEquals(Integer.MAX_VALUE, action.getActionType().intValue());
    }

}