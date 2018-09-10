package arc.java.io;

import arc.tool.PrintUtil;

import java.io.File;
import java.util.Objects;

/**
 * 磁盘操作类File
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 14:02
 * @version: 1.0
 */
public class FileTest {

    public static void listAllFiles(File dir) {
        if (Objects.isNull(dir) || !dir.exists()) {
            PrintUtil.print("param is null or file not exist !");
            return;
        }
        if (dir.isFile()) {
            PrintUtil.print(dir.getName());
            return;
        }

        for(File f:Objects.requireNonNull(dir.listFiles())){
            listAllFiles(f);
        }
    }

    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir"));
        listAllFiles(dir);
        PrintUtil.print();
    }
}
