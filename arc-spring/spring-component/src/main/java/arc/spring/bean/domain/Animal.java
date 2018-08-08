package arc.spring.bean.domain;

import arc.tool.PrintUtil;
import com.google.common.base.MoreObjects;

/**
 * 动物
 *
 * @author Swin
 * @version 1.0
 * @date 2018/8/7
 */
public class Animal {
    /**
     * 种类
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public Animal(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void getFuture(){
        PrintUtil.print(this.toString());
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("species", name)
                .add("age", age)
                .toString();
    }
}
