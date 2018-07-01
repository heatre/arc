package arc.spring.di.javaconfig;

import arc.spring.di.domain.Animal;
import arc.spring.di.domain.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 显式配置Rabbit bean
 * Profile注解声明该配置类在什么环境下生效，要确定那个profile生效需要设置spring.profile.active和spring.profile.default
 * 两个属性,如果没有上面两个属性都没有配置，则只会创建没有配置在profile注解中的bean
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Configuration
@Profile("dev")
public class RabbitJavaConfig {

    @Bean(name="fruit")
    public Food food() {
        int choice = (int)Math.floor(Math.random()*4);
        if(choice == 0){
           return new Fruit("苹果","山东");
        }
        return new Fruit("胡萝卜", "中国");
    }


    @Bean(name="rabbit")
    public Animal rabbit() {
        return new Rabbit("兔子", 1, food(), "灰");
    }

    /**
     * 由于spring默认的是单例，spring会拦截food()，food()与rabbit()方法总的food()一致
     * @return
     */
    @Bean(name="rabbit")
    public Animal anotherRabbit() {
        return new Rabbit("兔子", 2, food(), "灰");
    }
}
