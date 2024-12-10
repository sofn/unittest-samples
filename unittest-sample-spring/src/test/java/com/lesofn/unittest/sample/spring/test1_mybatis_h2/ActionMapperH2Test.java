package com.lesofn.unittest.sample.spring.test1_mybatis_h2;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author sofn
 * @since 2022-05-19 21:22
 */
public class ActionMapperH2Test extends SpringDaoBizH2Base {

    @Resource
    private ActionMapper actionMapper;

    @Test
    public void selectAction() {
        Action action = actionMapper.queryFirst();
        assertNull(action);
    }


}