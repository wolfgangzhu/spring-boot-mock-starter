package com.wolfgangzhu.mock.example.service;

import com.wolfgangzhu.mock.annotation.MockService;

/**
 * @author wolfgang
 * @date 2020-07-10 17:22:15
 * @version $ Id: MockTestServiceImpl.java, v 0.1  wolfgang Exp $
 */
@MockService("testService")
public class MockTestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("i am mock service");
    }
}
