package com.ash7sha.Ash7sha.application.config;

import com.ash7sha.Ash7sha.application.aop.logging.LoggingAspect;

import io.github.Ash7sha.config.Ash7shaConstants;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @Profile(Ash7shaConstants.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}
