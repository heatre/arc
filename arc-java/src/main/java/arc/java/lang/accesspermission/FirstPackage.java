package arc.java.lang.accesspermission;

/**
 * 访问权限测试
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/7/4 13:28
 * @version: 1.0
 */
public class FirstPackage {

    //private 权限 , 仅本类可以访问,其他包类无权限
    private String privatePermission = "privatePermission";

    //protected 权限,本包类、子类访问,其他包类无权限
    protected String protectedPermission = "protectedPermission";

    //default 权限,只能本包访问,其他包类无权限
    String defaultPermission = "defautPersmisson";

    //public 权限,所有包类都可以访问
    public String publicPermission = "publicPermission";


}
