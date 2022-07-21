package org.yong.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuys
 * @date 2022-07-19
 * @description
 */
public class RWLDemo {

    private static Map<String, Object> mapCache = new HashMap<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static Object get(String key) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        try {
            return mapCache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static void set(String key, Object o) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            mapCache.put(key, o);
        } finally {
            writeLock.unlock();
        }
    }


}
