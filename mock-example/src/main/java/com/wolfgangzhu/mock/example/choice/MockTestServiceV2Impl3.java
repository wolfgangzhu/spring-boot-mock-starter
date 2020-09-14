package com.wolfgangzhu.mock.example.choice;

import com.wolfgangzhu.mock.annotation.MockChoice;

/**
 * @author wolfgang
 * @date 2020-09-14 18:06:58
 * @version $ Id: MockTestServiceV2Impl3.java, v 0.1  wolfgang Exp $
 */
@MockChoice(value = "testV2", category = "v3")
public class MockTestServiceV2Impl3 implements TestServiceV2 {
    @Override
    public void exec() {
        System.out.println("case3: i am mock service");
    }
}
