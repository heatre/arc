package arc.java.lang.accesspermission.test;

import arc.java.lang.accesspermission.FirstPackage;
import arc.tool.PrintUtil;

/**
 * TODO
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 13:54
 * @version: 1.0
 */
public class SecondPackageTest {
    public static void main(String[] args) {
        FirstPackage test = new FirstPackage();

//        default 权限,只能本包访问,其他包类无权限
//        PrintUtil.print(defaultMethod.defaultPermission);
//
//        protected 权限,本包类、子类访问,其他包类无权限
//        PrintUtil.print(defaultMethod.protectedPermission);

        PrintUtil.print(test.publicPermission);

        SecondPackage test1 = new SecondPackage();

        //default 权限,只能本包访问,其他包类无权限
        PrintUtil.print(test1.defaultPermission);

        //protected 权限,本包类、子类访问,其他包类无权限
        PrintUtil.print(test1.protectedPermission);

//      public 权限,所有包类都可以访问
        PrintUtil.print(test1.publicPermission);
    }
}
