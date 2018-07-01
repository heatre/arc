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
