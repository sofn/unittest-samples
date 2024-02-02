package com.lesofn.unittest.sample.spring.test5_testable;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sofn
 * @date 2022-05-20 12:07
 */
@Service
public class ActionServiceTestable {

    @Resource
    private ActionMapper mapper;

    public Action queryFirst() {
        return mapper.queryFirst();
    }

}
