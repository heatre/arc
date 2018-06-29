package arc.spring.di.autoconfig;

import arc.spring.di.domain.Food;
import org.springframework.stereotype.Component;

/**
 * 水果
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Component
public class Fruit implements Food {
    /**
     * 名称
     */
    private String name;
    /**
     * 产地
     */
    private String place;

    public Fruit(){
        this.name = "胡萝卜";
        this.place = "湖南";
    }


    @Override
    public String getFoodName() {
        return name;
    }

    public String getPlace() {
        return place;
    }
}
