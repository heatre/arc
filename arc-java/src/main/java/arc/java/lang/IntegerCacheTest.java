package arc.java.lang;


import static arc.tool.PrintUtil.print;

/**
 * Integer cache 验证,，Integer 缓存池的大小默认为 -128~127,下面都存在缓存
 *
 * boolean values true and false
 * all byte values
 * short values between -128 and 127
 * int values between -128 and 127
 * char in the range \u0000 to \u007F
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/6/30 10:32
 * @version: 1.0
 */
public class IntegerCacheTest {
    private static final int low = -128;
    private static final int high = 127;

    public static void main(String[] args) {
        //创建新对象地址为460,并将127放入缓存
        Integer a = new Integer(high);

        //创建新对象地址为461,缓存中含有127
        Integer a1 = new Integer(high);
        //直接引用缓存中的127,地址为462
        Integer a2 = Integer.valueOf(high);
        Integer a3 = Integer.valueOf(high);

        //创建新对象地址为463,因为 IntegerCache 默认缓存最大值为127最小为-128,所以128不放入缓存
        Integer b = new Integer(high + 1);
        //创建新对象地址为464,IntegerCache 中没有 128
        Integer b1 = Integer.valueOf(high + 1);
        //创建新对象地址为465, ,IntegerCache 中没有 128
        Integer b2 = Integer.valueOf(high + 1);

        //true
        print(a.equals(a1));
        //false
        print(a == a1);
        //false
        print(a == a2);
        //true
        print(a2 == a3);
        //false
        print(b == b1);
        //false
        print(b2 == b1);


    }


}
