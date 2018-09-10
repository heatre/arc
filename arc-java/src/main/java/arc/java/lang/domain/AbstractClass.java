package arc.java.lang.domain;

/**
 * 抽象类测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/2 16:52
 * @version: 1.0
 */
public abstract class AbstractClass implements InterfaceClass {
    protected final String className = "AbstractClass";
    private Integer version = 1;

    /**
     * 抽象方法
     * @return
     */
    public abstract String getClassName();

    /**
     * 公有方法
     * @return
     */
    @Override
    public Integer getVersion(){
        return version;
    }
}
