package com.wolfgangzhu.mock.example;

import com.wolfgangzhu.mock.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wolfgang
 * @date 2020-07-10 17:19:23
 * @version $ Id: MockApplication.java, v 0.1  wolfgang Exp $
 */
@SpringBootApplication
public class MockApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MockApplication.class, args);
    }

    @Autowired
    TestService testService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testService.test();

    }
}
