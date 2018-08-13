package arc.spring.bean.test;

import arc.spring.bean.domain.Animal;
import arc.spring.bean.domain.Fruit;
import arc.tool.PrintUtil;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * bean主要通过工厂方法创建
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/8
 */
public class BeanCreateTest {
    public static void main(String[] args) {

        //bean定义
        GenericBeanDefinition b1 = new GenericBeanDefinition(new RootBeanDefinition(Fruit.class));
        AnnotatedGenericBeanDefinition b2 = new AnnotatedGenericBeanDefinition(Animal.class);

        //bean注册
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        registry.registerBeanDefinition(b1.getBeanClassName(),b1);
        registry.registerBeanDefinition(b2.getBeanClassName(),b2);
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
        reader.register(Animal.class);

        //bean创建
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition(b1.getBeanClassName(),b1);
        beanFactory.registerBeanDefinition(b2.getBeanClassName(),b2);


        PrintUtil.print(beanFactory.getBeanDefinitionCount());

    }
}
