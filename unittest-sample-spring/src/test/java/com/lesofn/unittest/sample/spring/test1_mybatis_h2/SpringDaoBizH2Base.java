package com.lesofn.unittest.sample.spring.test1_mybatis_h2;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sofn
 * @since 2022-05-07 10:18
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = {"classpath:springh2/spring-properties.xml", "classpath:springh2/spring-datasource-biz.xml"})
public abstract class SpringDaoBizH2Base {
}
