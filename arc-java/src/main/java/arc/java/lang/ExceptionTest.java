package arc.java.lang;

import arc.tool.PrintUtil;

/**
 * 异常测试
 * Throwable 是所有异常的基类，具体分为Error和Exception两大类，
 * 其中Error为jvm无法处理的错误，而Exception异常又可以分为两类：运行时异常（RuntimeException）和非运行时异常
 * 运行时异常：这类异常为不受检异常，往往是由于程序逻辑错误引起的如ArrayIndexOutOfBoundsException，NullPointerException等
 * 非运行异常：运行时异常的之外的异常如IOException、SQLException以及一些用户自定义的异常
 * 受检异常：在正确的程序运行过程中，很容易出现的、情理可容的异常状况，在一定程度上这种异常的发生是可以预测的，
 * 并且一旦发生该种异常，就必须采取某种方式进行处理。
 * 非受检异常：包括RuntimeException及其子类和Error。
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 15:56
 * @version: 1.0
 */
public class ExceptionTest {
    public static final String className = "ExceptionTest";

    public static class MyException extends Exception {
        private String msg = "MyException";

        @Override
        public String toString() {
            return "MyException{" +
                    "msg='" + msg + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        String name = null;
        String[] color = {"red", "green", "blue"};
        try {
            try {

                if (color.length > 4) {
                    throw new MyException();
                }

                if (name == null) {
                    throw new NullPointerException();
                }
                PrintUtil.print(color[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                PrintUtil.print("catch ArrayIndexOutOfBoundsException :" + e.toString());
            }
        } catch (MyException e) {
            PrintUtil.print("catch MyException :" + e.toString());
        } catch (NullPointerException e) {
            PrintUtil.print("catch NullPointerException :" + e.toString());
        }

    }
}
