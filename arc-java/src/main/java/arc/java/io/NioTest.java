package arc.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

/**
 * Nio
 * I/O 与 NIO 最重要的区别是数据打包和传输的方式，I/O 以流的方式处理数据，而 NIO 以块
 * 的方式处理数据。
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 16:34
 * @version: 1.0
 */
public class NioTest {

    public static void fastCopy(String src, String dist) throws Exception {

        FileInputStream in = new FileInputStream(Objects.requireNonNull(src, "src is null !"));
        FileOutputStream out = new FileOutputStream(Objects.requireNonNull(dist, "dist is null !"));

        FileChannel inChannel = in.getChannel();
        FileChannel outChanel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            int r = inChannel.read(buffer);
            if(r == -1){
                break;
            }
            //切换通道
            buffer.flip();
            outChanel.write(buffer);
            buffer.clear();
        }

    }

    public static void main(String[] args) throws Exception {
        String userDir = System.getProperty("user.dir");
        String src = userDir + "/test.txt";
        String dist = userDir + "/test2.txt";
        fastCopy(src, dist);
    }
}
