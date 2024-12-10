package com.lesofn.unittest.demo.springboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sofn
 * @since 2022-06-02 10:01
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test1")
    public String test() {
       return "hello";
    }

}
