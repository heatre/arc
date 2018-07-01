package arc.spring.di.autoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * 根配置：可以导入其他的配置类
 * @Import 注解导入其他jvaa配置
 * @ImportResource 注解导入xml配置，如 @ImportResource(locations = "classpath:config.xml")
 * Profile注解声明该配置类在什么环境下生效，要确定那个profile生效需要设置spring.profile.active和spring.profile.default
 * 两个属性,如果没有上面两个属性都没有配置，则只会创建没有配置在profile注解中的bean
 * @author Swin
 * @version 1.0
 * @date 2018/7/1
 */
@Configuration
@Import(RabbitAutoConfig.class)
@Profile("dev")
public class RootConfig {
}
