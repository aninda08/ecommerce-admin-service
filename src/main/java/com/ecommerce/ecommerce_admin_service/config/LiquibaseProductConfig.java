package com.ecommerce.ecommerce_admin_service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseProductConfig {
    @Bean
    public SpringLiquibase productLiquibase(@Qualifier("productDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/product/changelog/db.changelog-product.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.product")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }
}
