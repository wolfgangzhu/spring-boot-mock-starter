/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2020 All Rights Reserved.
 */

package com.wolfgangzhu.mock.annotation;

import com.wolfgangzhu.mock.condition.RealCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wolfgang
 * @date 2020-06-14 13:57:06
 * @version $ Id: MockService.java, v 0.1  wolfgang Exp $
 */
@Service
@Retention(RetentionPolicy.RUNTIME)
@Conditional(RealCondition.class)
public @interface RealService {
    String value();
}
