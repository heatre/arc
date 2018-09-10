package arc.java.concurrence;

import java.util.concurrent.*;

import static arc.tool.PrintUtil.print;
import static java.lang.Thread.sleep;

/**
 * TODO
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/8 20:27
 * @version: 1.0
 */
public class ExecutorTest {

    public static class RunnableTask implements Runnable {
        private int taskNo;

        public RunnableTask(int taskNo) {
            this.taskNo = taskNo;
        }

        @Override
        public void run() {
           print("task:" + taskNo + " start");
            try {
                sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("task:" + taskNo + " finish");
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(2));
        for (int i = 0; i < 7; i++) {
            RunnableTask task = new RunnableTask(i);
            executor.execute(task);
            print("poolSize:"+executor.getPoolSize());
            print("queueSize:"+executor.getQueue().size());
            print("activeCount:"+executor.getActiveCount());
            print("completedTaskCount:"+executor.getCompletedTaskCount());
            print("largestPoolSize:"+executor.getLargestPoolSize());
            print("taskCount:"+executor.getTaskCount());

        }
        executor.shutdown();
    }
}
