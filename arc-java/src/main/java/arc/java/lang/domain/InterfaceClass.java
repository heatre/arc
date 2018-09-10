package arc.java.lang.domain;

import arc.tool.PrintUtil;

/**
 * jdk1.8 interface测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/2 16:38
 * @version: 1.0
 */
public interface InterfaceClass {

    /**
     * 接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者protected
     */
    Integer version = 1;

    /**
     * 1.8后接口可以提供默认方法，和成员变量
     */
    default void defaultMethod() {
        PrintUtil.print(version);
    }

    /**
     * do SomeThing
     */
    Integer getVersion();
}
