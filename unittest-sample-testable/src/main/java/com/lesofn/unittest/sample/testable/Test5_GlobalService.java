package com.lesofn.unittest.sample.testable;

import com.lesofn.unittest.sample.testable.infrastructure.BasicService;

/**
 * @author sofn
 * @date 2022-05-18 20:14
 */
public class Test5_GlobalService {

    private BasicService basicService = new BasicService();

    public String get(String key) {
        return basicService.get(key);
    }

    public void set(String key, String value) {
        basicService.set(key, value);
    }

}
