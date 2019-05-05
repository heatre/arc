package arc.algorithm;


/**
 * 整数反转
 *
 * @author Mustache Zhang
 * @version 1.0
 * @date 2019/4/28 16:10
 */
public class TestB {

    /**
     * 整数反转
     * @param x
     * @return
     */
    public static int reverseInt(int x) {
        long r = 0;
        long tmp = x;
        //循环遍历取参数的各个位的值
        while (tmp != 0) {
            r = r * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        // 反转溢出判断
        if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
            r = 0;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        int a = (int) Math.pow(2, 31) - 1;
        int b = 123456789;
        System.out.println(reverseInt(a));
        System.out.println(reverseInt(b));
    }
}