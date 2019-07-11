import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/7/11 11:16
 * description:
 */
public class ThreadTest {

    @Test
    public void createTest() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        thread.start();
        thread.join();
        System.out.println(2);
    }

    @Test
    public  void createTest1() throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        thread.start();
        thread.join();
        System.out.println(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });
        thread1.start();
        thread1.join();
        System.out.println(4);
    }
}
