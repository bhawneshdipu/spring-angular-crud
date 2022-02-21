package com.bhawnesh.angular.crud.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GenericConstants {
    public static final String[] DATE_FORMATS = new String[]{
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSX",
            "yyyy-MM-dd'T'HH:mm:ss z",
            "yyyy-MM-dd HH:mm:ss z",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm",
            "yyyy-MM-dd'T'HH"
    };
}
