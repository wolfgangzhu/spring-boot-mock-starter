package com.wolfgangzhu.mock.condition;

import com.wolfgangzhu.mock.annotation.RealService;

/**
 * @author wolfgang
 * @date 2020-07-08 17:19:38
 * @version $ Id: MockConditional.java, v 0.1  wolfgang Exp $
 */
public class RealCondition extends AbstractMockCondition {

    public RealCondition() {
        super(RealService.class, false);
    }
}
