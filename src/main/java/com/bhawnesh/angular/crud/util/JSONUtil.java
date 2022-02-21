package com.bhawnesh.angular.crud.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JSONUtil {
    public static final ObjectMapper MAPPER=new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .findAndRegisterModules()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static String toString(Object obj){
        try{
            return MAPPER.writeValueAsString(obj);
        }catch (Exception ex){
            log.error("{}",ex.getMessage(),ex);
            return obj.toString();
        }
    }
    public static <T> T toObject(String str,Class<T> tClass){
        try{
            return MAPPER.convertValue(str,tClass);
        }catch (Exception ex){
            log.error("{}",ex.getMessage(),ex);
            return null;
        }
    }
    public static <T> T toObject(String str, TypeReference<T> typeReference){
        try{
            return MAPPER.convertValue(str,typeReference);
        }catch (Exception ex){
            log.error("{}",ex.getMessage(),ex);
            return null;
        }
    }
    public static <T> T toObject(Object obj,Class<T> tClass){
        try{
            return MAPPER.convertValue(obj,tClass);
        }catch (Exception ex){
            log.error("{}",ex.getMessage(),ex);
            return null;
        }
    }
    public static <T> T toObject(Object obj, TypeReference<T> typeReference){
        try{
            return MAPPER.convertValue(obj,typeReference);
        }catch (Exception ex){
            log.error("{}",ex.getMessage(),ex);
            return null;
        }
    }

}
