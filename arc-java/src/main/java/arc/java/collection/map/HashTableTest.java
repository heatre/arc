package arc.java.collection.map;

import arc.java.domain.Apple;

import java.util.Hashtable;

/**
 * HashTable 测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:31
 * @version: 1.0
 */
public class HashTableTest {
    public static void main(String[] args){
        Hashtable map = new Hashtable();

        map.put(new Apple("red",0.1,false),"v1");
        map.put(new Apple("green",0.2,true),"v2");
        map.put(new Apple("blue",0.3,true),"v3");
        map.put(new Apple("orange",0.4,false),"v4");


    }
}
