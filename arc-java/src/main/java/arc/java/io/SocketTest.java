package arc.java.io;

import arc.tool.PrintUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络IO操作通过InputStream、OutPutStream
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 16:34
 * @version: 1.0
 */
public class SocketTest {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://127.0.0.1:8888");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null) {
            PrintUtil.print(line);
            line = br.readLine();
            br.close();
        }
    }
}

