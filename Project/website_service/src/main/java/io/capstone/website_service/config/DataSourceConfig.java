package io.capstone.website_service.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    /**
     * Redefining the datasource configurations as Bean
     * @return datasource object
     */
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/capstoneproject");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("Eb914649.");

        return dataSourceBuilder.build();
    }
}
