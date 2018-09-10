package arc.java.lang;

import arc.java.lang.domain.Apple;
import arc.java.lang.domain.Fruit;
import arc.tool.PrintUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 泛型测试
 *
 * @author: Swin
 * @date: 2018/7/4 16:20
 * @version: 1.0
 */
public class GenericsTest {

    /**
     * 泛型类
     *
     * @param <K,V>
     */
    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair() {
            PrintUtil.print("default constructor invoked");
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * 泛型方法，边界符用例
     *
     * @param p1
     * @param p2
     * @param <K>
     * @param <V>
     * @return
     */
    public <K extends Comparable<K>, V extends Comparable<V>> boolean isEqual(Pair<K, V> p1, Pair<K, V> p2) {
        PrintUtil.print("isEqual method invoked");
        return p1.getKey().compareTo(p2.getKey()) == 0 && p1.getValue().compareTo(p2.getValue()) == 0;
    }

    /**
     * 通配符用例，原则 Producer Extends, Consumer Super
     *
     * @param list
     * @param <T>
     * @return
     */
    public <T> Object getFirstItem(List<? extends T> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            PrintUtil.print("getFirstItem method invoked " + list.get(0));
            return list.get(0);
        }
        return null;
    }

    /**
     * 通配符用例，原则 Producer Extends, Consumer Super
     *
     * @param dest
     * @param src
     * @param <T>
     */
    public  <T> void copy(List<? super T> dest, List<? extends T> src) {
        PrintUtil.print("copy method invoked");
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }

        PrintUtil.print(dest.toArray());
    }


    public static void main(String[] args) {
        GenericsTest genericsTest = new GenericsTest();

        Pair<Integer, String> p1 = genericsTest.new Pair<>(Integer.valueOf(1), "a");
        Pair<Integer, String> p2 = genericsTest.new Pair<>(Integer.valueOf(2), "b");

        genericsTest.isEqual(p1, p2);

        List<String> strings = Lists.newArrayList("a","b");
        List<Integer> integers = Lists.newArrayList(Integer.valueOf(1),Integer.valueOf(2));
        genericsTest.getFirstItem(strings);
        genericsTest.getFirstItem(integers);

        List<Apple> apples = Lists.newArrayList(new Apple("red apple"),new Apple("green apple"));
        List<Fruit> fruits = Lists.newArrayList();

        genericsTest.copy(fruits,apples);

    }
}
