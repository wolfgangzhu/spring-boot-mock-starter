package com.wolfgangzhu.mock.condition;

import com.wolfgangzhu.mock.MockConstant;
import com.wolfgangzhu.mock.annotation.RealService;

/**
 * @author wolfgang
 * @date 2020-07-08 17:19:38
 * @version $ Id: MockConditional.java, v 0.1  wolfgang Exp $
 */
public class RealCondition extends AbstractMockConditionV1 {

    public RealCondition() {
        super(MockConstant.DEFAULT_CATEGORY_REAL, "mock.compatible.real-name", RealService.class);
    }
}
