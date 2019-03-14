package cache.guava;

import com.google.common.cache.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-03-14 19:55
 */
public class GuavaCacheService {
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5)//缓存容量设为5，实际上只用到1个
//            .refreshAfterWrite(3, TimeUnit.SECONDS)//设置定时刷新
            .expireAfterWrite(1, TimeUnit.SECONDS)//如果数据长时间没有被访问，则强制刷新
            .removalListener((removalNotification) -> // 匿名内部类RemovalListener
                System.out.println(Thread.currentThread().getId() + ":移除key：" + removalNotification.getKey())
            )
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws InterruptedException {
                    System.out.println(Thread.currentThread().getId() + ":开始移除key");
                    Thread.sleep(5000);
                    LocalDateTime dateTime = LocalDateTime.now();
                    String time = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    System.out.println(Thread.currentThread().getId() + ":移除成功");
                    return "key_" + key + "_" + time;
                }
            });

    public static void main(String[] args) throws Exception {
        new Thread(()->{
            while (true) {
                String val = null;
                try {
                    val = localCache.get("a");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ":" +  val);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            String val = localCache.get("a");
            System.out.println(Thread.currentThread().getId() + ":" + val);
            Thread.sleep(1000);
        }
    }
}
