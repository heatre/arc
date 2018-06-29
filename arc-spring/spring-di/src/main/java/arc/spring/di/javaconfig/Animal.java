package arc.spring.di.javaconfig;

/**
 * 动物
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
public interface Animal {

    /**
     * 获取品种
     * @return
     */
    String getSpecies();

    /**
     * 获取年龄
     * @return
     */
    Integer getAge();

    /**
     * 吃啥
     * @return
     */
    Food getFood();

    /**
     * 获取动物的特征
     */
    void getFeature();
}
