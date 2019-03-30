package commontest;


import java.util.UUID;

/**
 * @Description 小测试
 * @Author lilong
 * @Date 2019-03-16 14:47
 */
public final class Test {
    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getId() + ": " + threadLocal.get());
                System.out.println(Thread.currentThread().getId() + ": " + threadLocal.get());
                System.out.println(Thread.currentThread().getId() + ": " + threadLocal.get());
            }).start();
        }
    }
}
