package com.dean.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;


/**
 * @author: Dean
 * @Date: 2018/8/1 11:16
 * @Description:
 */
public abstract class SingletonTest<S> {

    private final Supplier<S> singletonInstanceMethod;

    public SingletonTest(final Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    /**
     * 非多线程
     */
    @Test
    public void nonConcurrent(){
        S instance1 = this.singletonInstanceMethod.get();
        S instance2 = this.singletonInstanceMethod.get();
        S instance3 = this.singletonInstanceMethod.get();

        Assertions.assertSame(instance1,instance2);
        Assertions.assertSame(instance2,instance3);

    }
    /**
     * 多线程
     */
    @Test
    public void concurrent(){

        //超时判断
        assertTimeout(ofMillis(10000), () -> {
            final List<Callable<S>> tasks = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                tasks.add(this.singletonInstanceMethod::get);
            }

            // 用8个线程去跑这么多task
            final ExecutorService executorService = Executors.newFixedThreadPool(8);
            final List<Future<S>> results = executorService.invokeAll(tasks);

            // executorService.invokeAll 会阻塞  等待多有执行完毕
            final S expectedInstance = this.singletonInstanceMethod.get();
            for (Future<S> res : results) {
                final S instance = res.get();
                assertNotNull(instance);
                assertSame(expectedInstance, instance);
            }

            executorService.shutdown();
        });

    }


}
