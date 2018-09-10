package arc.java.io;

import arc.java.domain.Person;
import arc.tool.PrintUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化ObjectInputStream、ObjectOutStream
 *
 * @author: ZHANGZHIQIANG136
 * @date: 2018/8/6 15:20
 * @version: 1.0
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("user.dir");
        String outFile = dir+"/test2";
        Person p1 = new Person("Dr.T","Dr",18);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outFile));
        objectOutputStream.writeObject(p1);
        PrintUtil.print(p1);

        ObjectInputStream inputStream =  new ObjectInputStream(new FileInputStream(outFile));
        Person p2 = (Person)inputStream.readObject();
        PrintUtil.print(p2);
    }
}
