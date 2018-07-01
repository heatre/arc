package arc.spring.di.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 根配置：可以导入其他的配置类
 * @Import 注解导入其他jvaa配置
 * @ImportResource 注解导入xml配置
 * @author Swin
 * @version 1.0
 * @date 2018/7/1
 */
@Configuration
@Import(RabbitJavaConfig.class)
@ImportResource(locations = "classpath:config.xml")
public class RootConfig {
}
