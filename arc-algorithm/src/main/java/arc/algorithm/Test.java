package arc.algorithm;

/**
 * 大整数相加测试类
 *
 * @author Mustache Zhang
 * @version 1.0
 * @date 2019/4/28 16:10
 */
public class Test {

    /**
     * 大整数相加
     * @param num1 整数1
     * @param num2 整数2
     * @return
     */
    public static String addTwoNum(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        //进位
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        //依次取相应的位相加
        while (carry == 1 || i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            str.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1111111111111111";
        String b = "22222222222222222222";
        System.out.println(addTwoNum(a,b));
    }

}