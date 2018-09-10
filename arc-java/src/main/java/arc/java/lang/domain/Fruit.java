package arc.java.lang.domain;

/**
 * Fruit
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/6 11:09
 * @version: 1.0
 */
public class Fruit extends AbstractClass {
    private String className = "Fruit";

    /**
     * 抽象方法
     *
     * @return
     */
    @Override
    public String getClassName() {
        return className;
    }
}
