package arc.java.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Todo
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/5/11 10:36
 * @version: 1.0
 */
public class Person implements Serializable {
    private String name;
    private String profession;
    /**
     * 0 男，1 女
     */
    private int sex;
    private int age;

    public Person() {

    }

    public Person(String name, String profession, int age, int sex) {
        this.name = name;
        this.profession = profession;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String profession, int age) {
        this.name = name;
        this.profession = profession;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMan() {
        return sex == 0;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("profession", profession)
                .add("sex", sex)
                .add("age", age)
                .toString();
    }
}
