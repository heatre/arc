package arc.java.lang.accesspermission;

import arc.java.lang.accesspermission.test.SecondPackage;
import arc.tool.PrintUtil;

/**
 * TODO
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 13:54
 * @version: 1.0
 */
public class FirstPackageTest {
    public static void main(String[] args) {
        FirstPackage test = new FirstPackage();
        PrintUtil.print(test.defaultPermission);
        PrintUtil.print(test.protectedPermission);
        PrintUtil.print(test.publicPermission);

        SecondPackage test1 = new SecondPackage();
//
//        //default 权限只能本包访问,其他包类无权限
//        PrintUtil.print(test1.defaultPermission);
//
//        //protected 权限本包类、子类访问,其他包类无权限
//        PrintUtil.print(test1.protectedPermission);

        PrintUtil.print(test1.publicPermission);

    }
}
