package cache.guava;

import com.google.common.cache.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Description guava本地缓存
 * @Author lilong
 * @Date 2019-03-14 19:55
 */
public class GuavaCacheService {
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5) // 缓存容量设为5，实际上只用到1个
            .refreshAfterWrite(3, TimeUnit.SECONDS) // 一个线程load，其他线程返回旧值
//            .expireAfterWrite(3, TimeUnit.SECONDS) // 一个线程load，其他线程阻塞等待
            .removalListener((removalNotification) -> { // 匿名内部类RemovalListener
                        System.out.println(Thread.currentThread().getName() + ":已移除");
                    }
            )
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws InterruptedException {
                    System.out.println(Thread.currentThread().getName() + ":开始移除key..." + key);
                    Thread.sleep(5000);
                    LocalDateTime dateTime = LocalDateTime.now();
                    String time = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    System.out.println(Thread.currentThread().getName() + ":移除成功key..." + key);
                    return "key_" + key + "_" + time;
                }
            });

    public static void main(String[] args) {
        new Thread(new GetCache(), "Thread-1").start();
        new Thread(new GetCache(), "Thread-2").start();

        new Thread(() -> {
            while (true) {
                System.out.println(localCache.asMap());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-3").start();
    }

    static class GetCache implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    String val = localCache.get("a");
                    System.out.println(Thread.currentThread().getName() + ":" + val);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
