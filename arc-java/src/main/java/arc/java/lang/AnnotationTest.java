package arc.java.lang;

import arc.java.lang.domain.Apple;
import arc.java.lang.domain.FruitName;
import arc.tool.PrintUtil;

import java.lang.reflect.Field;

/**
 * 注解测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 16:21
 * @version: 1.0
 */
public class AnnotationTest {
    public static void main(String[] args){
      Class<?> clazz = Apple.class;

        Field[] fields = clazz.getDeclaredFields();
       for(Field f:fields){
           if(f.isAnnotationPresent(FruitName.class)){
               FruitName fruitName = f.getAnnotation(FruitName.class);
               String fn = fruitName.value();
               PrintUtil.print(fn);
           }
       }
    }
}
