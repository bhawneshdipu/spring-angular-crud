package com.bhawnesh.angular.crud.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JSONUtil {
    public static ObjectMapper MAPPER=new ObjectMapper();

    public static String toString(Object obj){
        try{
            return MAPPER.writeValueAsString(obj);
        }catch (Exception ex){
            return obj.toString();
        }
    }
    public static <T> T toObject(String str,Class<T> tClass){
        try{
            return MAPPER.convertValue(str,tClass);
        }catch (Exception ex){
            return null;
        }
    }
    public static <T> T toObject(String str, TypeReference<T> typeReference){
        try{
            return MAPPER.convertValue(str,typeReference);
        }catch (Exception ex){
            return null;
        }
    }
    public static <T> T toObject(Object obj,Class<T> tClass){
        try{
            return MAPPER.convertValue(obj,tClass);
        }catch (Exception ex){
            return null;
        }
    }
    public static <T> T toObject(Object obj, TypeReference<T> typeReference){
        try{
            return MAPPER.convertValue(obj,typeReference);
        }catch (Exception ex){
            return null;
        }
    }

}
