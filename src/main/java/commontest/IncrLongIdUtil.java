package commontest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于snowflake实现自增id
 *
 * @Author: jinliang
 * @Date: 2019/3/13
 */
public final class IncrLongIdUtil {
    /**
     * 开始的时间戳
     */
    private final static long STARTA_UNIX_TIME = 1552453976000L;
    /**
     * 序列号占位
     */
    private final static long SEQUENCE_BITS = 12;
    /**
     * 机器占位
     */
    private final static long WORK_ID_BITS = 10;
    /**
     * 64占位
     */
    private final static long TOTAL_BITS = 64;
    /**
     * 机器最大值
     */
    private final static long MAX_WORK_ID = ~(-1L << WORK_ID_BITS);
    /**
     * 机器左移位数
     */
    private final static long WORK_LEFT_MOVE = SEQUENCE_BITS;
    /**
     * 时间戳左移位数
     */
    private final static long TIMESTMP_LEFT_MOVE = WORK_LEFT_MOVE + WORK_ID_BITS;


    private long workId = 0L;
    private AtomicInteger sequenceId = new AtomicInteger(0);
    private long lastTime = -1L;

    public IncrLongIdUtil() {
    }

    public IncrLongIdUtil(long workId) {
        if (workId > MAX_WORK_ID || workId < 0) {
            throw new IllegalArgumentException("机器序列号不能超过最大值，不能小于0");
        }
        this.workId = workId;
    }

    /**
     * 获取ID
     *
     * @return
     */
    public long nextId() {
        long currentTime = System.currentTimeMillis();
        if (currentTime < lastTime) {
            throw new RuntimeException("时钟回拨异常");
        }
        if (currentTime != lastTime) {
            synchronized (this) {
                currentTime = System.currentTimeMillis();
                if (currentTime < lastTime) {
                    throw new RuntimeException("时钟回拨异常");
                }
                if (currentTime != lastTime) {
                    lastTime = currentTime;
                    sequenceId.set(0);
                }
            }
        }

        int count = sequenceId.getAndIncrement();
        if (count > (1 << SEQUENCE_BITS)) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return nextId();
        }
        return (currentTime - STARTA_UNIX_TIME) << TIMESTMP_LEFT_MOVE
                | workId << WORK_LEFT_MOVE
                | count;

    }
    public static void main(String[] args) {
        IncrLongIdUtil incrLongIdUtil = new IncrLongIdUtil();

        for (int i = 0; i < 1000 * 10000; i++) {
            incrLongIdUtil.nextId();
        }
    }
}