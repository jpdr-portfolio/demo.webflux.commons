package com.jpdr.apps.demo.webflux.commons.caching;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpdr.apps.demo.webflux.commons.exception.CacheProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class DtoSerializer<T> implements RedisSerializer<T> {
  
  private final ObjectMapper objectMapper;
  private final Class<T> type;
  
  @Override
  public byte[] serialize(T value) throws SerializationException {
    String serializedObject = toString(value);
    return serializedObject.getBytes(StandardCharsets.UTF_8);
  }
  
  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
    String serializedObject = new String(bytes);
    return fromString(serializedObject);
  }
  
  public String toString(T data){
    try{
      return this.objectMapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
      throw new CacheProcessingException(e);
    }
  }
  
  public T fromString(String data){
    try {
      return this.objectMapper.readValue(data, type);
    } catch (JsonProcessingException  e) {
      throw new CacheProcessingException(e);
    }
  }
  
}
