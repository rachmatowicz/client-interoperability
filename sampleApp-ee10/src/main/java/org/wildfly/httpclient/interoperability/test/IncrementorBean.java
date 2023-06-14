package org.wildfly.httpclient.interoperability.test;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class IncrementorBean implements Incrementor {
    private final AtomicInteger count = new AtomicInteger();

    @Override
    public Result<Integer> increment() {
        return new Result<>(this.count.getAndIncrement());
    }
}
