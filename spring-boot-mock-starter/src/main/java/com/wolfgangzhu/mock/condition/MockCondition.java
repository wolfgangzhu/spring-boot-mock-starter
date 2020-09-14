package com.wolfgangzhu.mock.condition;

import com.wolfgangzhu.mock.MockConstant;
import com.wolfgangzhu.mock.annotation.MockService;

/**
 * @author wolfgang
 * @date 2020-07-08 17:19:38
 * @version $ Id: MockConditional.java, v 0.1  wolfgang Exp $
 */
public class MockCondition extends AbstractMockConditionV1 {

    public MockCondition() {
        super(MockConstant.DEFAULT_CATEGORY_MOCK, "mock.compatible.mock-name", MockService.class);
    }

}
