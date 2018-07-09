package arc.spring.di.autoconfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * 苹果
 * "@Component"标志当前类为一个bean
 * "@Primary"设置当前bean为首选项
 * "@Conditional"表示ExistsCondition类满足条件时才会创建bean
 * "@Scope"标识当前bean的作用域，Spring中定义了4中bean的作用域。
 *  Singleton（单例），在整个应用中只会创建一个bean的实例
 *  ProtoType（原型），每次注入和通过spring上下文获取的时候都会创建一个新的bean的实例
 *  Session（会话），web应用中，spring为每个会话创建一个bean实例
 *  Request（请求），web应用中，spring为每个请求创建一个bean实例
 * @author Swin
 * @version 1.0
 * @date 2018/7/9
 */
@Component
@Primary
@Scope(value =ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.INTERFACES)
@Conditional(ExistsCondition.class)
public class Apple extends Fruit {
}
