package threadpool;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-05-27 22:20
 */
public class Main {
    private static AtomicInteger ai = new AtomicInteger();

    private static ThreadPoolExecutor logisticsServiceExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5), // 设置队列大小，对过多的请求进行降级，防止排队过久
            new ThreadFactoryBuilder().setNameFormat("Main-%d").build(),
            new RejectedExecutionHandler() { // 降级，不再处理过多的订单，防止长时间排队
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("#### 线程池已经饱和了");
                }
            });

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logisticsServiceExecutor.execute(()->{
                System.out.println("活跃线程数：" + logisticsServiceExecutor.getActiveCount());
                System.out.println(Thread.currentThread().getName() + "::" + ai.getAndIncrement());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("------------------------------");
        System.out.println("活跃线程数：" + logisticsServiceExecutor.getActiveCount());

        Thread.sleep(15000);
        System.out.println("------------------------------");
        System.out.println("活跃线程数：" + logisticsServiceExecutor.getActiveCount());
    }
}
