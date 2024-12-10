package com.lesofn.unittest.sample.spring.test2_spring_annotation.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author sofn
 * @since 2022-05-20 00:08
 */
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer zebraMapperScannerConfigurer() {
        MapperScannerConfigurer zebraMapperScannerConfigurer = new MapperScannerConfigurer();
        zebraMapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        zebraMapperScannerConfigurer.setBasePackage("com.lesofn.unittest.sample.spring.mybatis");
        return zebraMapperScannerConfigurer;
    }

}
