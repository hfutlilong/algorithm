package nfc;

import com.netease.haitao.nfc.strategy.Strategy;
import com.netease.haitao.nfc.strategy.StrategyBuilder;
import com.netease.haitao.nfc.strategy.StrategyType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-06-12 15:18
 */
public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void main(String[] args) throws InterruptedException {
        Strategy strategy = StrategyBuilder.newBuilder().strategyType(StrategyType.LOCAL_LEAKY_BUCKET).limit(3).timeout(1000).build();

        AtomicInteger ai = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                if (strategy.acquire()) {
                    try {
                        System.out.println(ai.getAndIncrement());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        strategy.release();
                    }
                }
            });
        }

        Thread.sleep(5000);
        System.out.println("=======================");

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                if (strategy.acquire()) {
                    try {
                        System.out.println(ai.getAndIncrement());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        strategy.release();
                    }
                }
            });
        }
    }
}
