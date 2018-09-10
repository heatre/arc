package arc.java.collection.set;

import arc.java.domain.Apple;
import arc.tool.PrintUtil;

import java.util.HashSet;

/**
 * HashSet 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:20
 * @version: 1.0
 */
public class HashSetTest {
    public static void main(String[] args){
        HashSet set = new HashSet(2,0.75f);

        set.add(new Apple("red",0.1,false));
        set.add(new Apple("green",0.2,true));
        set.add(new Apple("blue",0.3,true));
        set.add(new Apple("orange",0.4,false));

        set.stream().forEach(x-> PrintUtil.print(x));
    }
}
