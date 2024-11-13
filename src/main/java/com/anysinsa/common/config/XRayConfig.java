package com.anysinsa.common.config;

import com.amazonaws.xray.jakarta.servlet.AWSXRayServletFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XRayConfig {
    @Bean
    public Filter tracingFilter() {
        return new AWSXRayServletFilter("brand-service");
    }
}