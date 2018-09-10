package arc.java.collection.map;

import arc.java.domain.Apple;
import arc.tool.PrintUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:28
 * @version: 1.0
 */
public class TreeMapTest {
    public static void main(String[] args){
        TreeMap map = new TreeMap();

        map.put(new Apple("red",0.1,false),"v1");
        map.put(new Apple("green",0.2,true),"v2");
        map.put(new Apple("blue",0.3,true),"v3");
        map.put(new Apple("orange",0.4,false),"v4");

        map.entrySet().stream().forEach(x->{
            Map.Entry entry  = (Map.Entry)x;
            PrintUtil.print(entry.getKey()+":"+entry.getValue());
        });
    }
}
