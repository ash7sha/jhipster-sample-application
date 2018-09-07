package com.ash7sha.Ash7sha.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Ash7sha Sample Application.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.Ash7sha.config.Ash7shaProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
