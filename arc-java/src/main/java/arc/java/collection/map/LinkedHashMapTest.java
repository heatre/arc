package arc.java.collection.map;

import arc.java.domain.Apple;
import arc.tool.PrintUtil;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMapTest 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:30
 * @version: 1.0
 */
public class LinkedHashMapTest {
    public static void main(String[] args){
        LinkedHashMap map = new LinkedHashMap();

        map.put(new Apple("red",0.1,false),"v1");
        map.put(new Apple("green",0.2,true),"v2");
        map.put(new Apple("blue",0.3,true),"v3");
        map.put(new Apple("orange",0.4,false),"v4");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry  = (Map.Entry)iterator.next();
            PrintUtil.print(entry.getKey()+":"+entry.getValue());
        }



    }
}
