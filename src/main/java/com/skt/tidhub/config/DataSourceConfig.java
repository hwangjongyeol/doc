package com.skt.tidhub.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaAuditing
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource datasource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
