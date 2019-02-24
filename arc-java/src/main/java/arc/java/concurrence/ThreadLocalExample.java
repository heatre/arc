package arc.java.concurrence;

/**
 * TODO
 *
 * @author Mustache Zhang
 * @version 1.0
 * @date 2019/2/23
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("thread2 end");
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }
}

