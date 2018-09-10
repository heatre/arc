package arc.java.collection.list;

import arc.java.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Vector 测试
 *
 * Vector的实现和ArrayList类似，但使用synchronized关键字进行同步
 * Vector默认容量也是10，与ArrayList一致，但是每次扩容的时候都扩为原来的2倍。
 * 了获得线程安全的 ArrayList，可以使用 Collections.synchronizedList()，得到一个线程安全的 ArrayList。
 * 也可以使用concurrent 并发包下的 CopyOnWriteArrayList 类
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:19
 * @version: 1.0
 */
public class VectorTest {
    public static void main(String[] args){

        List<Person> people = new Vector<>(10);
        people.add(new Person());

        //使用Collections.synchronizedList()创建同步list
        List<Person> people1 = Collections.synchronizedList(new ArrayList<>());

        //使用CopyOnWriteArrayList代替Vector使用
        List<Person> people2 = new CopyOnWriteArrayList<Person>();
    }

}
