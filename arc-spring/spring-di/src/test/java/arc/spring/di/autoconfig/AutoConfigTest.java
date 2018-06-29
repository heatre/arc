package arc.spring.di.autoconfig;

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
@ContextConfiguration(classes = RabbitAutoConfig.class)
public class AutoConfigTest {

    @Autowired
    private RabbitServiceImpl rabbitServiceImpl;

    @Test
    public void RabbitTest(){
        rabbitServiceImpl.getFeature();
    }
}
