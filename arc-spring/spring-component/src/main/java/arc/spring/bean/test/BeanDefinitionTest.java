package arc.spring.bean.test;

import arc.spring.bean.config.RootConfig;
import arc.spring.bean.domain.Fruit;
import arc.tool.PrintUtil;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean定义验证
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/7
 */
public class BeanDefinitionTest {
    public static void main(String[] args){
        //从配置源（XML，Java Config等）中生成的BeanDefinition
        RootBeanDefinition b1 = new RootBeanDefinition(RootConfig.class);
        GenericBeanDefinition b2 = new GenericBeanDefinition(b1);

        //从注解中生成BeanDefinition
        AnnotatedGenericBeanDefinition b3 = new AnnotatedGenericBeanDefinition(Fruit.class);

        PrintUtil.print(b1.getBeanClassName());
        PrintUtil.print(b2.getBeanClassName());
        PrintUtil.print(b3.getMetadata().getAnnotationTypes());

        //临时保存BeanDefinition来传递BeanDefinition。
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(b3,b3.getBeanClassName());
        PrintUtil.print(beanDefinitionHolder.getBeanName());
        System.exit(0);
    }

}
