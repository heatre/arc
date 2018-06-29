package arc.spring.di.autoconfig;

import org.springframework.context.annotation.ComponentScan;

/**
 * 显式配置Rabbit bean
 * @ComponentScan 默认扫描与配置类相同的包及这个包下面所有的子包，这里扫描autoconfig这个包下所有组件
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@ComponentScan
public class RabbitAutoConfig {

}
