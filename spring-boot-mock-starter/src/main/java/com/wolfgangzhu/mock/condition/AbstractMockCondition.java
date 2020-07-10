package com.wolfgangzhu.mock.condition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.lang.annotation.Annotation;

/**
 * @author wolfgang
 * @date 2020-07-08 18:03:21
 * @version $ Id: AbstractMockCondition.java, v 0.1  wolfgang Exp $
 */
public class AbstractMockCondition extends SpringBootCondition {

    private Class<? extends Annotation> annotationClass;

    private boolean mock;

    public AbstractMockCondition(Class<? extends Annotation> annotationClass, boolean mock) {
        this.annotationClass = annotationClass;
        this.mock = mock;
    }

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> valueMap = metadata.getAllAnnotationAttributes(annotationClass.getName());
        if (valueMap == null) {
            return new ConditionOutcome(true, "");
        }
        String value = (String) valueMap.get("value").get(0);

        // mock.service.leaf
        Boolean isMock = context.getEnvironment().getProperty("mock.service." + value + ".enabled", Boolean.class);
        if (isMock == null) {
            //
            isMock = context.getEnvironment().getProperty("mock.service.enabled", Boolean.class, false);
            return new ConditionOutcome(isMock == mock, "mock.service.enabled=" + isMock);

        } else {
            return new ConditionOutcome(isMock == mock, "mock.service." + value + "enabled=" + isMock);
        }
    }
}
