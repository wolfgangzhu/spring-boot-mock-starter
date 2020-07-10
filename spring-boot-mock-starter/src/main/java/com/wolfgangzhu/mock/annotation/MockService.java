package com.wolfgangzhu.mock.annotation;

import com.wolfgangzhu.mock.condition.MockCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wolfgang
 * @date 2020-06-14 13:57:06
 * @version $ Id: MockService.java, v 0.1  wolfgang Exp $
 */
@Service
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MockCondition.class)
@Documented
public @interface MockService {
    String value();
}
