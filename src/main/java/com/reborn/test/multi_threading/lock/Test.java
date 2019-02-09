package com.reborn.test.multi_threading.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }


}
