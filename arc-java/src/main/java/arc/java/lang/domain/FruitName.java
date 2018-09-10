package arc.java.lang.domain;

import java.lang.annotation.*;


/**
 * 水果名称注解
 * <p>
 * Target(ElementType.TYPE) 定义注解应用在什么位置如：类、构造器、方法、属性等上面
 * Retention(RetentionPolicy.RUNTIME) 定义注解的生命周期 存在于编译期、类加载时期、始终保留
 * Documented 定义将注解加入javadoc中
 * Inherited 定义注解是否可以被继承
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/6/27 14:13
 * @version: 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FruitName {

    /**
     * 名称
     *
     * @return
     */
    String value() default "";


    /**
     * 颜色属性
     */
    String fruitColor() default "";
}