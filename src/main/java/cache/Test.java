package cache;

/**
 * @Description 测试缓存
 * @Author lilong
 * @Date 2019-02-27 19:21
 */
public class Test {
    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(3);

        for (int i = 2 ; i < 9; i++) {
            cache.put(i);
            System.out.println(cache);
        }
        System.out.println("################");

        for (int i = 0 ; i < 10; i++) {
            printCacheEle(cache, i);
        }
    }

    private static void printCacheEle(LRUCache<Integer> cache, int i) {
        Integer a = cache.get(i);
        System.out.println(a);
        System.out.println(cache);
    }
}
