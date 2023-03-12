import util.PathUtil;

import java.io.*;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */

public class ReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(PathUtil.SOURCE_FILE_PATH);
        writer.write("Hello from other side");
        writer.close();

        Reader reader = new FileReader(PathUtil.SOURCE_FILE_PATH);
        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();
    }
}
