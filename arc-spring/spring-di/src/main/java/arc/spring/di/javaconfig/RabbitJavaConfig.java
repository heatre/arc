package arc.spring.di.javaconfig;

import arc.spring.di.domain.Animal;
import arc.spring.di.domain.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 显式配置Rabbit bean
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Configuration
public class RabbitJavaConfig {

    @Bean
    public Food getFood() {
        return new Fruit("胡萝卜", "中国");
    }

    @Bean
    public Animal getRabbit() {
        return new Rabbit("兔子", 1, getFood(), "灰");
    }
}
