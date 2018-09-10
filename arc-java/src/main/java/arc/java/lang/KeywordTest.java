package arc.java.lang;

import arc.java.lang.domain.ObjectClass;
import arc.tool.PrintUtil;

/**
 * final，static等关键字测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 14:47
 * @version: 1.0
 */
public class KeywordTest {
    /**
     * final修饰的字段会被当成编译时常量，final修饰局部变量中则当成运行时常量
     *
     */
    private final int version = 1;

    /**
     * final修饰的引用字段表示该字段不能再引用其他的对象，但是当前引用对象仍然是可以修改的
     */
    private final ObjectClass objectClass = new ObjectClass();


    /**
     * 静态变量在内存中只有一份，仅在类初始化的时候初赋值一次
     */
    public static String className = getClassName();

    /**
     * 静态语句块也是在类初始化的时候运行一次，
     * 静态变量的初始化优于实例变量的初始化，实例的变量的初始化优先于构造函数
     * 静态变量和静态语句块的执行先后顺序取决于它们在代码中的位置
     */
    static {
        PrintUtil.print("static block !");

    }

    /**
     * 访问权限为public的内部类
     */
    public class InnerClass{
        public InnerClass(){
            PrintUtil.print("Inner class constructor init !");
        }
    }

    /**
     * 静态内部类
     * 非静态内部类依赖于需要外部类的实例，而静态内部类不需要
     * 静态内部类不能访问外部类的非静态的变量和方法
     */
    public static class StaticInnerClass{
        public StaticInnerClass(){
            PrintUtil.print("Static inner class constructor init !");
        }
    }




    public KeywordTest(){
        PrintUtil.print("constructor init !");
    }

    /**
     * 静态方法在类加载的时候就存在了，并不依赖于任何实例，所以静态方法必须有实现，不能声明为abstract
     * 只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字
     * @return
     */
    public static String getClassName(){
        PrintUtil.print("getClassName() invoke !");
        return className;
    }

    public static void main(String[]  args){
        KeywordTest test = new KeywordTest();

        //非静态内部类依赖于需要外部类的实例，而静态内部类不需要
        InnerClass innerClass = test.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }
}

