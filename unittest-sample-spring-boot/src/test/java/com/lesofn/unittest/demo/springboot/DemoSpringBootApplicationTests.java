package com.lesofn.unittest.demo.springboot;

import com.lesofn.unittest.demo.springboot.rest.DemoController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoSpringBootApplicationTests {

    @Resource
    private DemoController demoController;

    @Test
    void test_controller() {
        String test = demoController.test();
        assertEquals("hello", test);
    }

}
