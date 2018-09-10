package arc.java.collection.list;

import arc.java.domain.Person;
import arc.java.util.TestDataUtils;
import arc.tool.PrintUtil;

import java.util.LinkedList;

/**
 * LinkedList 测试
 * LinkedList使用双向链表是实现，使用内部类Node存储元素。
 * 由于LinkedList使用链表实现，所以不支持随机访问，同时实现Queue接口所以既可以当做list、stack、queue使用
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/9 15:18
 * @version: 1.0
 */
public class LinkedListTest {

    public static void main(String[] args){
        LinkedList<Person> people = (LinkedList<Person>)TestDataUtils.getDefaultPersonLinkedList(10);

        PrintUtil.print(people);
    }
}
