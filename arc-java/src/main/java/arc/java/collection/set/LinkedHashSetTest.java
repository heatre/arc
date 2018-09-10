package arc.java.collection.set;

import arc.java.domain.Apple;
import arc.tool.PrintUtil;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:22
 * @version: 1.0
 */
public class LinkedHashSetTest {
    public static void main(String[] args){
        LinkedHashSet set = new LinkedHashSet(2,0.75f);

        set.add(new Apple("red",0.1,false));
        set.add(new Apple("green",0.2,true));
        set.add(new Apple("blue",0.3,true));
        set.add(new Apple("orange",0.4,false));

        set.stream().forEach(x-> PrintUtil.print(x));
    }
}
