package arc.spring.di.autoconfig;

import arc.spring.di.domain.Food;
import arc.tool.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 兔子实现类
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Component("redRabbit")
public class RabbitImpl implements Rabbit {

    /**
     * 种类
     */
    private String species;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 饮食
     */
    private Food food;

    /**
     * 主要颜色
     */
    private String color;

    /**
     * 当进行构造函数注入时，构造函数参数必须是容器中已经装载的bean,否则会报装载异常；
     * 比如当前构造函数上加上 @Autowired 注解，由于String,Integer,Food类型的bean并不存在Spring 容器中所以会报异常
     * @param species 种类
     * @param age 年龄
     * @param food 食物
     * @param color 颜色
     */
    public RabbitImpl(String species, Integer age, Food food, String color){
        this.species = species;
        this.age = age;
        this.food = food;
        this.color = color;
    }

    /**
     * 构造函数注入
     * @param food
     */
    @Autowired
    public RabbitImpl(Fruit food){
        this.food = food;
    }

    /**
     * 当不存在其他构造函数时，默认调用不带参数构造函数初始化bean
     */
    public RabbitImpl(){
        this.species = "兔子";
        this.age = 1;
        this.food = new Fruit();
        this.color = "灰";
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public Food getFood() {
        return food;
    }

    @Override
    public void getFeature() {
        PrintUtil.print(color+ " " +getSpecies() + " 喜欢吃 "+ getFood().getFoodName());
    }

}
