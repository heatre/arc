package arc.spring.di.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 显式配置Rabbit bean
 * "@ComponentScan"注释 默认扫描与配置类相同的包及这个包下面所有的子包，这里扫描autoconfig这个包下所有组件
 * "basePackageClasses"配置表示以RabbitAutoConfig、Rabbit类所在包作为基础包
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Configuration
@ComponentScan(basePackageClasses = {RabbitAutoConfig.class, Rabbit.class})
public class RabbitAutoConfig {

}
