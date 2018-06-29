package arc.spring.di.javaconfig;

/**
 * 肉类食品
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
public class Meat implements Food {
    /**
     * 名称
     */
    private String name;
    /**
     * 重量
     */
    private Double weight;

    public Meat(String n,Double w){
        this.name = n;
        this.weight = w;
    }

    @Override
    public String getFoodName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }
}
