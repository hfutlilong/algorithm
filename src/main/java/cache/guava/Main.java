package cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;
import util.LogUtil;

import java.util.concurrent.TimeUnit;

/**
 * @Description 本地缓存
 * @Author lilong
 * @Date 2019-06-10 16:09
 */
public class Main {
    public static Cache<String, String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5) // 缓存容量
//            .expireAfterWrite(5, TimeUnit.SECONDS) // 过期时间
            .expireAfterWrite(5, TimeUnit.SECONDS) // 过期时间
            .removalListener(notification -> {
                LogUtil.print("########## Removed local cache, key={}, value={}, reason={}.",
                        notification.getKey(), notification.getValue(), notification.getCause());
            }).build();

    public static void main(String[] args) {
        System.out.println("start size: " + localCache.size());

        for (int i = 0; i < 10; i++) {
            String a = localCache.getIfPresent("key_" + i);
            if (StringUtils.isBlank(a)) {
                localCache.put("key_" + i, "value_" + i);
            }
        }

        System.out.println("mid size: " + localCache.size());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("sss" + localCache.getIfPresent(String.valueOf(18)));

        System.out.println("end size: " + localCache.size());
//        localCache.invalidateAll();
//        System.out.println("end size: " + localCache.size());
    }
}
