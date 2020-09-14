package com.wolfgangzhu.mock.condition;

import com.wolfgangzhu.mock.annotation.MockChoice;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static com.wolfgangzhu.mock.MockConstant.DEFAULT_CATEGORY;

/**
 * @author wolfgang
 * @date 2020-09-14 17:10:20
 * @version $ Id: MockChoiceCondition.java, v 0.1  wolfgang Exp $
 */
public class MockChoiceCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MockProperty mockProperty = parseMockProperty(context, metadata);
        if (mockProperty == null) {
            return new ConditionOutcome(false, "property is empty");
        }

        // mock.service.leaf
        String categoryConfig = context.getEnvironment().getProperty("mock.service." + mockProperty.value + ".choice", String.class);

        if (StringUtils.isEmpty(categoryConfig)) {
            //
            categoryConfig = context.getEnvironment().getProperty("mock.service.choice", String.class, DEFAULT_CATEGORY);
        }
        return new ConditionOutcome(Objects.equals(mockProperty.category, categoryConfig),
                "mock.service.enabled=" + Objects.equals(mockProperty.category, categoryConfig));
    }

    protected MockProperty parseMockProperty(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> valueMap = metadata.getAllAnnotationAttributes(MockChoice.class.getName());
        if (valueMap == null) {
            return null;
        }
        String value = (String) valueMap.get("value").get(0);
        String category = (String) valueMap.get("category").get(0);
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("mockChoice#value can't be empty");
        }
        return new MockProperty(value, category);
    }

    class MockProperty {
        private String value;
        private String category;

        public MockProperty(String value, String category) {
            this.value = value;
            this.category = category;
        }
    }
}
