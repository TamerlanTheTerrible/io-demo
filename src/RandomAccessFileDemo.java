import util.PathUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(PathUtil.SOURCE_FILE_PATH, "rw")) {
            // read
            file.seek(2);
            int data = file.read();
            System.out.println((char) data);

            // write
            file.seek(10);
            file.write("Hello from RandomAccessFile".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
