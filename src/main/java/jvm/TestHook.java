package jvm;

/**
 * @Description JVM钩子函数
 * @Author lilong
 * @Date 2019-03-16 15:00
 */
public class TestHook {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("坐稳扶好，老司机开车了...");
        Runtime.getRuntime().addShutdownHook(new Thread(()->System.out.println("执行钩子函数")));
        System.out.println("oh yeah");
        Thread.sleep(3000);
    }
}
