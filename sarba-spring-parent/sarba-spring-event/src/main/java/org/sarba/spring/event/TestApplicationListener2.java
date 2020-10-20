package org.sarba.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class TestApplicationListener2 implements ApplicationListener<TestApplicationEvent>{
    @Override
    @Async
    public void onApplicationEvent(TestApplicationEvent testApplicationEvent) {
        System.out.println(Thread.currentThread().getId()+ "/" +Thread.currentThread().getName() + " msg2 :" + testApplicationEvent.getMsg());
    }
}
