package com.jpdr.apps.demo.webflux.commons.caching;

import com.jpdr.apps.demo.webflux.commons.exception.CacheProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@RequiredArgsConstructor
public class CacheHelper {
  
  private final CacheManager cacheManager;
  
  public <T> T put(String cacheName, Object cacheKey, T data){
    Cache cache = this.cacheManager.getCache(cacheName);
    if(cache == null){
      throw new CacheProcessingException("The cache " + cacheName + " wasn't found.");
    }
    try{
      cache.put(cacheKey, data);
      return data;
    } catch (Exception e) {
      throw new CacheProcessingException(e);
    }
    
  }
  
}
