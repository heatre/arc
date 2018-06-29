package arc.spring.di;

import arc.spring.di.javaconfig.RabbitConfig;
import arc.spring.di.javaconfig.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * java 显式配置 bean 测试
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RabbitConfig.class)
public class JavaConfigTest {

    @Autowired
    private Animal animal;

    @Test
    public void RabbitTest(){
        animal.getFeature();
    }
}
