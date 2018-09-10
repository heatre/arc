package arc.java.lang.domain;

/**
 * Orange
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/6 11:09
 * @version: 1.0
 */
public class Orange extends Fruit {
    private String name = "Orange";

    public Orange() {
    }

    public Orange(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
