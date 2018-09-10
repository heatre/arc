package arc.java.lang;

import arc.java.lang.domain.ObjectClass;
import arc.tool.PrintUtil;

/**
 * Object中方法测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 16:26
 * @version: 1.0
 */
public class ObjectTest {
    public static void main(String[] args) {
        ObjectClass o1 = new ObjectClass();
        ObjectClass o2 = new ObjectClass();

        PrintUtil.print(o1 == o2);
        PrintUtil.print(o1.hashCode() == o2.hashCode());
        PrintUtil.print(o1.equals(o2));

        Object o3 = new Object();
        Object o4 = new Object();
        PrintUtil.print(o3.hashCode());
        PrintUtil.print(o4.hashCode());
        PrintUtil.print(o3.equals(o4));

    }
}
