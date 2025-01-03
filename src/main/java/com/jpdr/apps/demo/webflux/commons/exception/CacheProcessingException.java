package com.jpdr.apps.demo.webflux.commons.exception;

public class CacheProcessingException extends RuntimeException{
  
  public CacheProcessingException(String message){
    super(message);
  }
  
  public CacheProcessingException(Throwable ex){
    super("An exception occurred while serializing.", ex);
  }
  
}
