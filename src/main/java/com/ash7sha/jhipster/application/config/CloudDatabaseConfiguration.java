package com.ash7sha.Ash7sha.application.config;

import io.github.Ash7sha.config.Ash7shaConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@Profile(Ash7shaConstants.SPRING_PROFILE_CLOUD)
public class CloudDatabaseConfiguration extends AbstractCloudConfig {

    private final Logger log = LoggerFactory.getLogger(CloudDatabaseConfiguration.class);

    @Bean
    public DataSource dataSource(CacheManager cacheManager) {
        log.info("Configuring JDBC datasource from a cloud provider");
        return connectionFactory().dataSource();
    }
}
