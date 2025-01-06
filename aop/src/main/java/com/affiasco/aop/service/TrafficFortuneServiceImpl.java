package com.affiasco.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morningz";
    }

    @Override
    public String getFortune(boolean flag) {

        if (flag) {
            throw new RuntimeException("Major accident! Highway is closed");
        }

        return getFortune();
    }
}
