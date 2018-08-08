package arc.spring.bean.test;

import arc.spring.bean.domain.Fruit;
import arc.tool.PrintUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * bean的注册、解析
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/8
 */
public class BeanDefinitionReaderTest {
    public static void main(String[] args) {

        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        //从bean的注解中读取bean的定义
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
        reader.register(Fruit.class);
        PrintUtil.print(registry.getBeanDefinitionCount());
        PrintUtil.print(Lists.newArrayList(registry.getBeanDefinitionNames()));
        System.exit(0);
    }
}
