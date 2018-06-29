package arc.spring.di.javaconfig;

import arc.tool.PrintUtil;

/**
 * TODO
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
public class Rabbit extends AbstractAnimal {
    /**
     * 主要颜色
     */
    private String color;

    public Rabbit(String species, Integer age, Food food, String color) {
        super(species,age,food);
        this.color = color;
    }

    @Override
    public void getFeature(){
        PrintUtil.print(color+ " " +super.getSpecies() + " 喜欢吃 "+ super.getFood().getFoodName());
    }
}
