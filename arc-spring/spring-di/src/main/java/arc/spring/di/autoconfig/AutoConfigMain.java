package arc.spring.di.autoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动装配启动类
 *
 * @author Swin
 * @version 1.0
 * @date 2018/7/9
 */
public class AutoConfigMain {

    public static void main(String[] args){
        ApplicationContext  context = new AnnotationConfigApplicationContext(RootConfig.class);
    }

}
