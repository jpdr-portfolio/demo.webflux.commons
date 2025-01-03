package com.jpdr.apps.demo.webflux.commons.configuration;

import com.jpdr.apps.demo.webflux.commons.caching.CacheHelper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheHelperConfig {
  
  @Bean
  public CacheHelper cacheHelper(CacheManager cacheManager){
    return new CacheHelper(cacheManager);
  }
  
}
