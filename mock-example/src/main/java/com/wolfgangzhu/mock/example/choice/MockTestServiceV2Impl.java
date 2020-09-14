package com.wolfgangzhu.mock.example.choice;

import com.wolfgangzhu.mock.annotation.MockChoice;

/**
 * @author wolfgang
 * @date 2020-09-14 18:04:15
 * @version $ Id: MockTestServiceV2Impl.java, v 0.1  wolfgang Exp $
 */
@MockChoice(value = "testV2", category = "mock")
public class MockTestServiceV2Impl implements TestServiceV2 {
    @Override
    public void exec() {
        System.out.println("i am mock service v2");
    }
}
