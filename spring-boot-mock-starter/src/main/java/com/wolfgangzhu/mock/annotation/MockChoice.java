package com.wolfgangzhu.mock.annotation;

import com.wolfgangzhu.mock.condition.MockChoiceCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.wolfgangzhu.mock.MockConstant.DEFAULT_CATEGORY;

/**
 * @author wolfgang
 * @date 2020-09-14 16:25:13
 * @version $ Id: MockChoise.java, v 0.1  wolfgang Exp $
 */
@Service
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MockChoiceCondition.class)
@Documented
public @interface MockChoice {

    String value();

    String category() default DEFAULT_CATEGORY;
}