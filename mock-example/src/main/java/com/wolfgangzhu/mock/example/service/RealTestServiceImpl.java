package com.wolfgangzhu.mock.example.service;

import com.wolfgangzhu.mock.annotation.RealService;

/**
 * @author wolfgang
 * @date 2020-07-10 17:21:30
 * @version $ Id: RealTestServiceImpl.java, v 0.1  wolfgang Exp $
 */
@RealService("testService")
public class RealTestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("i am real service");
    }
}
