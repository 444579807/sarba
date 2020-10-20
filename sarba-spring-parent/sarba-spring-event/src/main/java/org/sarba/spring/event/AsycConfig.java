package org.sarba.spring.event;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Configurable
public class AsycConfig {

    @Bean
    public Executor initExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //定制线程名称，还可以定制线程group
        executor.setThreadFactory(new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(Thread.currentThread().getThreadGroup(), r,
                        "async-eventListener-" + threadNumber.getAndIncrement(),
                        0);
                return t;
            }
        });
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(5);
        executor.setQueueCapacity(100);
//        executor.setRejectedExecutionHandler(null);
        return executor;
    }
}
