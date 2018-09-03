package com.ash7sha.Ash7sha.application.config;

import io.github.Ash7sha.async.ExceptionHandlingAsyncTaskExecutor;
import io.github.Ash7sha.config.Ash7shaProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

    private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

    private final Ash7shaProperties Ash7shaProperties;

    public AsyncConfiguration(Ash7shaProperties Ash7shaProperties) {
        this.Ash7shaProperties = Ash7shaProperties;
    }

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Ash7shaProperties.getAsync().getCorePoolSize());
        executor.setMaxPoolSize(Ash7shaProperties.getAsync().getMaxPoolSize());
        executor.setQueueCapacity(Ash7shaProperties.getAsync().getQueueCapacity());
        executor.setThreadNamePrefix("Ash7sha-sample-application-Executor-");
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
