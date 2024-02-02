package com.lesofn.unittest.sample.spring.test2_spring_annotation.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author sofn
 * @version 1.0 Created at: 2021-08-09 16:51
 */
@Configuration
@PropertySource({"classpath:config.properties"})
public class DataSourceConfig {

    @Value("${h2.jdbc-ref}")
    private String h2JdbcUrl;

    @Bean
    public DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(h2JdbcUrl);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }

}
