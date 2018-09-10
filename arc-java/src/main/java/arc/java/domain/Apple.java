package arc.java.domain;

import com.google.common.base.MoreObjects;

/**
 * 苹果类，实现object的equals()和hashCode()方法
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/10 9:39
 * @version: 1.0
 */
public class Apple implements Comparable{
    private String className = "Apple";
    private String color = "red";
    private Double weight = 0.5;

    /**
     * 是否返回相同的hashcode
     */
    private boolean sameHashCode = false;

    public Apple() {

    }

    public Apple(boolean sameHashCode) {

        this.sameHashCode = sameHashCode;
    }

    public Apple(String color, Double weight, boolean sameHashCode) {
        this.color = color;
        this.weight = weight;
        this.sameHashCode = sameHashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Apple apple = (Apple) o;

        if (!className.equals(apple.className)) {
            return false;
        }
        if (!color.equals(apple.color)) {
            return false;
        }
        return weight.equals(apple.weight);
    }

    @Override
    public int hashCode() {
        //如果需要返回相同hashcode则返回10
        if (sameHashCode){
            return 1;
        }
        int result = className.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }



    @Override
    public int compareTo(Object o) {
        Apple that = (Apple)o;
        return this.hashCode()-that.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("className", className)
                .add("color", color)
                .add("weight", weight)
                .add("sameHashCode", sameHashCode)
                .add("hashCode", this.hashCode())
                .toString();
    }
}
