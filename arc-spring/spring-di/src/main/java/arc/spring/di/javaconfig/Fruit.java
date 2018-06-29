package arc.spring.di.javaconfig;

/**
 * 水果
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
public class Fruit implements Food {
    /**
     * 名称
     */
    private String name;
    /**
     * 产地
     */
    private String place;

    public Fruit(String n,String p){
        this.name = n;
        this.place = p;
    }

    @Override
    public String getFoodName() {
        return name;
    }

    public String getPlace() {
        return place;
    }
}
