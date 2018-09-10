package arc.java.lang.domain;

/**
 * Apple
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/6 11:09
 * @version: 1.0
 */
public class Apple extends Fruit {
    @FruitName("Apple")
    private String name = "Apple";

    public Apple() {
    }

    public Apple(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
