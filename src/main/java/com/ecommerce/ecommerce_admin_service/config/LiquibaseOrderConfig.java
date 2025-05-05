package com.ecommerce.ecommerce_admin_service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseOrderConfig {
    @Bean
    public SpringLiquibase orderLiquibase(@Qualifier("orderDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/order/changelog/db.changelog-order.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.order")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().build();
    }
}
