package arc.java.lang;

import arc.tool.PrintUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 15:28
 * @version: 1.0
 */
public class ReflectTest {

    public final String className = "ReflectTest";

    public ReflectTest() {

    }

    public String getClassName() {
        return className;
    }

    public static void main(String[] args) throws Exception {
        ReflectTest reflectTest = new ReflectTest();

        //1.获取class对象
        Class c1 = Class.forName("arc.java.lang.ReflectTest");
        Class c2 = ReflectTest.class;
        Class c3 = reflectTest.getClass();

        //2.获取对象实例
        ReflectTest reflectTest1 = (ReflectTest)c1.newInstance();
        ReflectTest reflectTest2 = (ReflectTest) c1.getConstructor().newInstance();

        //3.获取方法
        Method[] methods = c1.getDeclaredMethods();
        Method[] methods1 = c1.getMethods();
        Method method = c1.getMethod("getClassName");

        //4.获取构造器
        Constructor constructor = c1.getConstructor();

        //5.获取成员变量
        Field field = c1.getField("className");
        Field[] fields =c1.getFields();
        Field field1 = c1.getDeclaredField("className");
        Field[] fields1 = c1.getDeclaredFields();


        PrintUtil.print(constructor.getName());
        PrintUtil.print(field.getName());
        PrintUtil.print(method.getName());
        PrintUtil.print(method.invoke(reflectTest));

    }
}
