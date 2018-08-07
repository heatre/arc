package arc.spring.bean.test;

import arc.spring.bean.domain.Fruit;
import arc.tool.PrintUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;

/**
 * bean注册
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/8
 */
public class BeanDefinitionRegistryTest {
    public static void main(String[] args) {

        //从注解中生成BeanDefinition
        AnnotatedGenericBeanDefinition b3 = new AnnotatedGenericBeanDefinition(Fruit.class);
        PrintUtil.print(b3.getMetadata().getClassName());

        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        registry.registerBeanDefinition("fruit",b3);

        PrintUtil.print(registry.getBeanDefinitionCount());
        PrintUtil.print(Lists.newArrayList(registry.getBeanDefinitionNames()));
        System.exit(0);
    }
}
