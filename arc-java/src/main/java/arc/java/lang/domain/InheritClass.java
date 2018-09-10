package arc.java.lang.domain;

/**
 * 继承测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/2 17:07
 * @version: 1.0
 */
public class InheritClass extends AbstractClass {

    private final String className = "InheritClass";

    /**
     * 抽象方法
     *
     * @return
     */
    @Override
    public String getClassName() {
        return className;
    }

    /**
     * 抽象方法
     *
     * @return
     */
    @Override
    public Integer getVersion() {
        return getVersion();
    }

}
