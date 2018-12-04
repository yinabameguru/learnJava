package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {

    private Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {

        public Sync(int num) {
            setState(num);
        }

        @Override
        protected int tryAcquireShared(int arg) {
//            int currentStatus = getState();
//            int newStatus = currentStatus - arg;
//            if (newStatus < 0) {
//                return -1;
//            }
//            if (compareAndSetState(currentStatus, newStatus)) {
//                return newStatus;
//            }
//            return -1;

            for (;;) {
                int currentStatus = getState();
                int newStatus = currentStatus - arg;
                if (newStatus < 0) {
                    return -1;
                }
                if (compareAndSetState(currentStatus, newStatus)) {
                    return newStatus;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
//            int currentStatus = getState();
//            int newStatus = currentStatus + arg;
//            if (compareAndSetState(currentStatus, newStatus))
//                return true;
//            return false;

            for (;;) {
                int currentStatus = getState();
                int newStatus = currentStatus + arg;
                if (compareAndSetState(currentStatus, newStatus))
                    return true;
            }
        }
    }


    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
