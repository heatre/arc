package arc.spring.bean.config;

import arc.spring.bean.domain.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/7
 */
@Configuration
public class RootConfig {
    @Bean
    public Animal Animal() {
        return new Animal("兔子",new Integer(1));
    }
}
