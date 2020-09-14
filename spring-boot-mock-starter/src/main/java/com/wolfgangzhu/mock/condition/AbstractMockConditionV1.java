package com.wolfgangzhu.mock.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;

/**
 * @author wolfgang
 * @date 2020-09-14 17:39:32
 * @version $ Id: AbstractMockConditionV1.java, v 0.1  wolfgang Exp $
 */
public class AbstractMockConditionV1 extends MockChoiceCondition {
    private String                      defaultCategory;
    private String                      compatibleName;
    private Class<? extends Annotation> annotationClazz;

    public AbstractMockConditionV1(String defaultCategory, String compatibleName, Class<? extends Annotation> annotationClazz) {
        this.defaultCategory = defaultCategory;
        this.compatibleName = compatibleName;
        this.annotationClazz = annotationClazz;
    }

    @Override
    protected MockProperty parseMockProperty(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> valueMap = metadata.getAllAnnotationAttributes(annotationClazz.getName());
        if (valueMap == null) {
            return null;
        }
        String value = (String) valueMap.get("value").get(0);
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("MockService#value can't be empty");
        }
        String compatibleCategory = context.getEnvironment().getProperty(compatibleName, String.class);
        String category;
        if (StringUtils.isEmpty(compatibleCategory)) {
            category = defaultCategory;
        } else {
            category = compatibleCategory;
        }

        return new MockProperty(value, category);
    }
}
