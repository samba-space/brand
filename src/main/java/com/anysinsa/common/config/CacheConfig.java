package com.anysinsa.common.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anysinsa.common.constants.CacheConfigType;
import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        Arrays.stream(CacheConfigType.values())
                .forEach(
                        cacheConfigType ->
                                cacheManager.registerCustomCache(
                                        cacheConfigType.getCacheName(),
                                        Caffeine.newBuilder()
                                                .expireAfterAccess(
                                                        cacheConfigType.getTtlSeconds(),
                                                        TimeUnit.SECONDS)
                                                .maximumSize(cacheConfigType.getMaxSize())
                                                .build()));

        return cacheManager;
    }
}
