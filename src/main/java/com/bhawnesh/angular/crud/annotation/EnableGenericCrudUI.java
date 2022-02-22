package com.bhawnesh.angular.crud.annotation;

import com.bhawnesh.angular.crud.config.GenericConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({GenericConfiguration.class})
public @interface EnableGenericCrudUI {
}
