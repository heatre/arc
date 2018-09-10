package arc.java.util;

import arc.java.domain.Person;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Map;

/**
 * 测试数据生成类
 * @author: ZHANGZHIQIANG136
 * @date: 2018/5/11 10:47
 * @version: 1.0
 */
public class TestDataUtils {

    public static Person getPerson(String name, String profession, int age, int sex) {
        return new Person(name, profession, age, sex);
    }

    public static Person getDefaultPerson() {
        return new Person("Tom", "doctor", 10, 1);
    }

    public static List getPersonList(Person person, int num, List list) {
        for (int i = 0; i < num; i++) {
            String n = person.getName() + i;
            String p = person.getProfession() + i;
            int a = person.getAge() + i;
            int s = RandomUtils.nextInt(0, 100000) % 2;
            Person person1 = new Person(n, p, a, s);
            list.add(person1);
        }
        return list;
    }

    public static List getDefaultPersonArrayList(int num) {
        return getPersonList(getDefaultPerson(), num,Lists.newArrayList());
    }

    public static List getDefaultPersonLinkedList(int num) {
        return getPersonList(getDefaultPerson(), num,Lists.newLinkedList());
    }


    public static Map<String, Person> getPersonMap(String key, Person person, int num) {
        Map<String, Person> map = Maps.newHashMap();
        if (num == 1){
            map.put(key,person);
            return  map;
        }

        for (int i = 0; i < num; i++) {
            String n = person.getName() + i;
            String p = person.getProfession() + i;
            int a = person.getAge() + i;
            int s = RandomUtils.nextInt(0, 100000) % 2;
            Person person1 = new Person(n, p, a, s);
            map.put(key + i, person1)
            ;
        }
        return map;
    }


    public static Map<String, Person> getDefaultPersonMap(int num) {
        return getPersonMap("key", getDefaultPerson(), num);
    }

    public static List<Map<String, Person>> getDefaultPersonListMap(int num) {
        List<Map<String, Person>> rList = Lists.newArrayList();
        Person person = getDefaultPerson();
        for (int i = 0; i < num; i++) {
            Person person1 = getPerson(person.getName() + i, person.getProfession() + i, person.getAge() + i,
                    RandomUtils.nextInt(0, 100000) % 2);
            Map<String, Person> m = getPersonMap("key" + i, person1, 1);
            rList.add(m);
        }
        return rList;
    }


}
