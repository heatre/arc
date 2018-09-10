package arc.java.collection.set;

import arc.java.domain.Apple;
import arc.tool.PrintUtil;

import java.util.TreeSet;

/**
 * TreeSet 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:21
 * @version: 1.0
 */
public class TreeSetTest {
    public static void main(String[] args){
        TreeSet set = new TreeSet();

        set.add(new Apple("red",0.1,false));
        set.add(new Apple("green",0.2,true));
        set.add(new Apple("blue",0.3,true));
        set.add(new Apple("orange",0.4,false));

        set.stream().forEach(x-> PrintUtil.print(x));
    }
}
