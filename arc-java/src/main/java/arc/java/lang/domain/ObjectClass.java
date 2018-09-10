package arc.java.lang.domain;

/**
 * Object测试类
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/2 17:19
 * @version: 1.0
 */
public class ObjectClass {

    private String className = "ObjectClass";
    private Integer version = 1;

    public ObjectClass() {
        super();
    }

    /**
     * 默认Object hashcode方法，返回的可能是对象的（虚拟）内存地址，具体取决于运行时库和JVM的具体实现
     * 覆盖equals方法时必须同时覆盖hashcode方法
     * @return
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getClassName().hashCode();
        result = 31 * result + getVersion().hashCode();
        return result;
    }

    /**
     * 自反性：x.equals(x) == true
     * 对称性: x.equals(y) == y.equals(x)   true
     * 传递性: x.equals(y),y.equals(z) => x.equals(z)==true
     * 一致性: x.equals(y) == e.equals(y)
     * 检查是否为同一个对象的引用，如果是直接返回 true；
     * 检查是否是同一个类型，如果不是，直接返回 false；
     * 将 Object 实例进行转型；
     * 判断每个关键域是否相等。
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ObjectClass that = (ObjectClass) obj;
        if (!that.getClassName().equals(getClassName())) {
            return false;
        }
        if (that.getVersion().intValue() != getVersion().intValue()) {
            return false;
        }
        return true;
    }

    /**
     * Cloneable 接口只是规定，如果一个类没有实现 Cloneable 接口又
     * 调用了 clone() 方法，就会抛出 CloneNotSupportedException
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 默认返回 ObjectClass@4554617c 这种形式，其中 @ 后面的数值为散列码的
     * 无符号十六进制表示
     * @return
     */
    @Override
    public String toString() {
        return "ObjectClass{" +
                "className='" + className + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    public String getClassName() {
        return className;
    }

    public Integer getVersion() {
        return version;
    }
}
