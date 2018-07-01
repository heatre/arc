package arc.spring.di.autoconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * 自动扫描测试类
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("dev")
public class AutoConfigTest {

    @Autowired
    private Rabbit rabbit;

    @Test
    public void notNullTest(){
        assertNotNull(rabbit);
    }

    @Test
    public void RabbitTest(){
        rabbit.getFeature();
    }
}
