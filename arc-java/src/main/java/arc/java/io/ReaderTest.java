package arc.java.io;

import arc.tool.PrintUtil;

import java.io.*;
import java.util.Objects;

/**
 * 字符操作Reader、Writer
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 14:54
 * @version: 1.0
 */
public class ReaderTest {

    public static void printByLine(String src) throws Exception {
        Reader reader = new InputStreamReader(
                new FileInputStream(Objects.requireNonNull(src, "src is null !")),"GBK");
        BufferedReader bufferReader = new BufferedReader(reader);
        String str;
        while ((str = bufferReader.readLine()) != null) {
            PrintUtil.print(str);
        }
        bufferReader.close();
    }

    public static void main(String[] args) throws Exception {
        String userDir = System.getProperty("user.dir");
        String src = userDir + "/test.txt";
        printByLine(src);
    }
}
