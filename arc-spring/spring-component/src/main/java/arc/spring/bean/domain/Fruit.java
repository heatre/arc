package arc.spring.bean.domain;

import arc.tool.PrintUtil;
import com.google.common.base.MoreObjects;
import org.springframework.stereotype.Component;

/**
 * 水果
 *
 * @author Swin
 * @version 1.0
 * @date 2018/6/29
 */
@Component("fruit")
public class Fruit {
    /**
     * 名称
     */
    private String name;
    /**
     * 产地
     */
    private String place;

    public Fruit(String name,String place) {
        this.name = name;
        this.place = place;
    }

    public String getFoodName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public void getFuture(){
        PrintUtil.print(this.toString());
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("place", place)
                .toString();
    }
}
