package com.wolfgangzhu.mock.condition;

import com.wolfgangzhu.mock.annotation.MockService;

/**
 * @author wolfgang
 * @date 2020-07-08 17:19:38
 * @version $ Id: MockConditional.java, v 0.1  wolfgang Exp $
 */
public class MockCondition extends AbstractMockCondition {

    public MockCondition() {
        super(MockService.class, true);
    }

}
