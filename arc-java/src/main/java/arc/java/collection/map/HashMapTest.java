package arc.java.collection.map;

import arc.java.domain.Apple;

import java.util.HashMap;

/**
 * HashMap 测试
 * 数据结构（数组+链表+红黑树（链地址法））、哈希桶默认容量（2<<4）、loadFacotor（装填因子）、threshod（阀值=容量*装填因子）、
 * size（键值对数）、modCount（内部结构发生变化的次数fail-fast）、
 * hash算法（hashcode、高低位异或运算、取模运算）、put方法、get方法、扩容机制、rehash算法
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:27
 * @version: 1.0
 */
public class HashMapTest {
    public static void main(String[] args){
        //HashMap默认容量为16，规定为2的n次幂，默认装填因子为0.75
        HashMap map = new HashMap(2,0.75f);

        map.put(new Apple("red",0.1,false),"v1");
        map.put(new Apple("green",0.2,true),"v2");
        map.put(new Apple("blue",0.3,true),"v3");
        map.put(new Apple("orange",0.4,false),"v4");


    }
}
