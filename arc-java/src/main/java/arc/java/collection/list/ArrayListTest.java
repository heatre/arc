package arc.java.collection.list;

import arc.java.domain.Person;
import arc.java.util.TestDataUtils;
import arc.tool.PrintUtil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 测试
 *
 * ArrayList实现RandomAccess接口，用数据存储数据，所以支持随机访问
 *
 * ArrayList默认capacity大小为10,每次调用add方式时都是检查当前list中size+1是否大于capacity大小，如果大于就需要对list进行扩容，
 * 会调用ensureCapacityInternal()方法，具体调用grow方法,newCapacity = odlCapacity+oldCapacity>>1 扩容1.5倍,在扩容过程中具体使用
 * Array.copy()方法，最底层则调用System.arraycopy()方法，创建一个新的数组然后将原有数据复制到新的数组中。
 *
 * 对于每次的remove操作都会有移位操作，会调用System.arrayCory()将删除位置后的element向前移动一位
 *
 * Fail-fast：ArrayList中存在modCount字段用于实现fail-fast机制，每次的add或者remove方法都会改变modCount的值，在进行序列化或者
 * 迭代等操作时，需要比较操作前后 modCount 是否改变，如果改变了需要抛出 ConcurrentModificationException。
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:17
 * @version: 1.0
 */
public class ArrayListTest {


    public static void main(String[] args) {

        //ArrayList默认capacity大小为10
        ArrayList<Person> people = (ArrayList<Person>) TestDataUtils.getDefaultPersonArrayList(10);

        //当添加一个新的element时,会调用ArrayList的ensureCapacityInternal方法对数组进行扩容1.5倍
        people.add(new Person());

        //fail-fast验证
        Iterator<Person> iter = people.iterator();
        int index = 0;
        while (iter.hasNext()){
            if(index == 3){
                people.remove(3);
            }
            PrintUtil.print(iter.next());
            index++;
        }


        PrintUtil.print("wait !");


    }
}
