package com.lesofn.unittest.sample.spring.test3_mockito;

import com.lesofn.unittest.sample.spring.mybatis.Action;
import com.lesofn.unittest.sample.spring.mybatis.ActionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sofn
 * @since 2022-05-20 12:07
 */
@Service
public class ActionService {

    @Autowired(required = false)
    private ActionMapper mapper;

    public Action queryFirst() {
        return mapper.queryFirst();
    }

}
