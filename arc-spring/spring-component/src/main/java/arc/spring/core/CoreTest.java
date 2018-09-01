package arc.spring.core;

import arc.tool.PrintUtil;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Spring core组件测试
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/13
 */
public class CoreTest {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = ResourceUtils.getURL("CoreTest.java");
        PrintUtil.print(url.getPath());

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("CoreTest.java");
        PrintUtil.print(resource.getFilename());


    }




}
