import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author boolean
 * Date: 2019/7/9 19:59
 * description:
 */
public class PoolTets {

    @Test
    public void test(){

    }

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-poolchen-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(new Thread());
        }
    }
}
