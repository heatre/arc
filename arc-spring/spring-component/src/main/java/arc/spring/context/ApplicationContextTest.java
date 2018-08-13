package arc.spring.context;

import arc.spring.bean.domain.Animal;
import arc.spring.bean.domain.Fruit;
import arc.tool.PrintUtil;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Context测试
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/13
 */
public class ApplicationContextTest {
    public static void main(String[] args) {

        //bean解析
        GenericBeanDefinition b1 = new GenericBeanDefinition(new RootBeanDefinition(Fruit.class));
        AnnotatedGenericBeanDefinition b2 = new AnnotatedGenericBeanDefinition(Animal.class);

        //bean注册
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        registry.registerBeanDefinition(b1.getBeanClassName(),b1);
        registry.registerBeanDefinition(b2.getBeanClassName(),b2);
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
        reader.register(Animal.class);

        //bean注册到容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition(b1.getBeanClassName(),b1);
        beanFactory.registerBeanDefinition(b2.getBeanClassName(),b2);

        //基于注解的应用上下文
        AnnotationConfigApplicationContext c1 = new AnnotationConfigApplicationContext(beanFactory);

        //基于类路径的应用上下文
        ClassPathXmlApplicationContext c2 = new ClassPathXmlApplicationContext();

        //基于文件系统xml配置的应用上下文
        FileSystemXmlApplicationContext c3 = new FileSystemXmlApplicationContext();

       // 基于注解的Web应用上下文
        AnnotationConfigWebApplicationContext c4 = new AnnotationConfigWebApplicationContext();

        //xml配置文件的应用上下文
        XmlWebApplicationContext c5 = new XmlWebApplicationContext();

        PrintUtil.print(c1.getBeanDefinitionCount());
    }
}
