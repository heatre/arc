package arc.java.lang;

import static arc.tool.PrintUtil.print;

/**
 * String类特性验证，包括string pool，String,StringBuffer，StringBuilder
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/6/30 11:32
 * @version: 1.0
 */
public class StringTest {
    public  static void main(String[] args) {
        /**
         * a1,a2 使用 "==" 对String对象赋值,编译时期在class文件中生成字面常量和符号引用
         * 在运行期间则会保存在运行时常量池当中,所以a,a1具有相同的引用,都是引用常量池中"abcd"
         * a3使用new运算符构建的String对象会在堆上分配,并不会去检测运行时常量池是否含有字面常量"abcd"
         */
        String a = "abcd";
        String a1 = "abcd";
        String a2 = new String("abcd");
        String a3 = a2.intern();

        //true
        print(a.equals(a1));
        //true
        print(a == a1);
        //false
        print(a == a2);

        //true
        print(a3 == a1);
        //false
        print(a3 == a2);
        //true
        print(a3 == a2.intern());

        /**
         * 在执行字符串相加过程中,一般情况下c>c1>c2>c3
         * c在编译时期就已经确认c的值为"abcde"
         * c1的执行过程:先从内存中取出"abcd"字符,在和"e"相加,在new一片新的内存放新的"abcde",
         * 编译器会做相关优化使用StringBuilder.append()进行相加操作,但是每次都需要new一个StringBuilder对象
         * c2和c3基本上具有相同的逻辑处理,不同之处在于StringBuilder不是线程安全的,StringBuffer使用 synchronized进行同步
         */
        String b = "abcd" + "e";
        String b1 = a + "e";
        String b2 = new StringBuilder(a).append("e").toString();
        String b3 = new StringBuffer(a).append("e").toString();



        print("wait !");
    }
}
