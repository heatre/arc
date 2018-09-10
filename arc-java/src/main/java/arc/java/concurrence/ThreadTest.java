package arc.java.concurrence;

import arc.tool.PrintUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Thread测试
 * 线程状态：New、Runnable、Blocking、Timed waiting、waiting、Terminated
 * 线程使用：Thread、Runnable、Callable、Executor
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/7 15:59
 * @version: 1.0
 */
public class ThreadTest {

    /**
     * 继承Thread类创建线程
     */
    public static class ThreadTask extends Thread {
        @Override
        public void run() {
            PrintUtil.print(this.getId()+":thread task");
        }
    }

    /**
     * 实现Runnable接口创建线程
     */
    private static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrintUtil.print("runnable task");
        }
    }

    /**
     * 实现Callable接口创建线程
     */
    static class CallableTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            PrintUtil.print("callable task");
            return new Integer(1);
        }
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTask threadTask  = new ThreadTask();
        RunnableTask runnableTask = new RunnableTask();
        CallableTask callableTask = new CallableTask();


        Thread t1= threadTask;
        Thread t2 = new Thread(runnableTask);

        FutureTask<Integer> futureTask = new FutureTask(callableTask);
        Thread t3= new Thread(futureTask);

        t1.start();
        t2.start();
        t3.start();

        PrintUtil.print("thread:"+t1.getState());
        PrintUtil.print("runnable:"+t2.getState());
        PrintUtil.print("callable:"+t3.getState());
        PrintUtil.print(futureTask.get());
    }
}
