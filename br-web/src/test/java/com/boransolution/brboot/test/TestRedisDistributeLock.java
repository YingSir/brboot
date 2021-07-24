package com.boransolution.brboot.test;

import com.boransolution.brboot.SpringBootStartApplication;
import com.boransolution.brboot.util.RedisDistributeLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest(classes = SpringBootStartApplication.class)    // 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)            // 使用Junit进行测试
@WebAppConfiguration                                // 进行Web应用配置
public class TestRedisDistributeLock {
    @Autowired
    private RedisDistributeLock redisDistributeLock;
    private AtomicInteger count = new AtomicInteger(35);

    /**
     * 在一个线程持有锁的过程中，不允许其他的线程持有锁
     *
     * @param redisDistributeLock
     * @param lockKey
     * @param threadName
     * @param retryTime
     */
    private void threadTest(RedisDistributeLock redisDistributeLock, String lockKey, String threadName, int retryTime, int n) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String value = redisDistributeLock.tryLock(lockKey, 10_000, retryTime);
                if (count.get() >= n) {
                    int left = count.addAndGet(-n);
                    System.out.println(threadName + "减库存，剩余: " + left + " 购买: " + n);
                } else {
                    System.out.println(threadName + "库存不足下单失败，当前库存: " + count.get() + " 购买： " + n);
                }
                redisDistributeLock.release(lockKey, value);
            }
        }).start();
    }

    @Test
    public void testRedisDistributeLock() throws InterruptedException {
        String lockKey = "lock_key";
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            threadTest(redisDistributeLock, lockKey, "t-" + i, random.nextInt(30), random.nextInt(3) + 1);
        }
        Thread.sleep(20 * 1000);
    }

}
