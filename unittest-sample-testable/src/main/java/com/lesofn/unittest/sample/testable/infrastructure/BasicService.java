package com.lesofn.unittest.sample.testable.infrastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sofn
 * @since 2022-05-19 15:15
 */
public class BasicService {

    Map<String, String> map = new HashMap<>();

    public String get(String key) {
        return map.get(key);
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

}
