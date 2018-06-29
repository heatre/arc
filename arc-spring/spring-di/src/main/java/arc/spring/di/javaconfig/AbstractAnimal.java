package arc.spring.di.javaconfig;

import arc.tool.PrintUtil;

/**
 * 狗
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
public class AbstractAnimal implements Animal {
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

    public AbstractAnimal(String species,Integer age,Food food){
        this.species = species;
        this.age = age;
        this.food = food;
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
        PrintUtil.print(getSpecies() + " like eat "+ getFood());
    }
}
