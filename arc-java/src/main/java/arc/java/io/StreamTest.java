package arc.java.io;

import arc.tool.PrintUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * 字节流操作InputStream、OutputStream
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 14:35
 * @version: 1.0
 */
public class StreamTest {
    public static void copyFile(String src, String dist) throws Exception {

        InputStream in = new FileInputStream(Objects.requireNonNull(src, "src is null !"));
        OutputStream out = new FileOutputStream(Objects.requireNonNull(dist, "dist is null !"));
        int cnt = 0;
        byte[] buffer = new byte[10];
        while (in.read(buffer, 0, buffer.length) != -1) {
            out.write(buffer);
            cnt++;
        }
        PrintUtil.print(cnt);
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        String userDir = System.getProperty("user.dir");
        String src = userDir + "/test.txt";
        String dist = userDir + "/test1.txt";
        copyFile(src, dist);
    }
}
