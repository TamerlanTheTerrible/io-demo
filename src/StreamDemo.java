import util.PathUtil;

import java.io.*;
import java.time.LocalDateTime;

/**
 * Created by Temurbek Ismoilov on 07/03/23.
 */

public class StreamDemo {
    public static void main(String[] args) throws IOException {
        bufferedIoDemo();
    }

    private static void simpleIoDemo() throws IOException {
        System.out.println("Started: " + LocalDateTime.now());
        InputStream is = new FileInputStream(PathUtil.SOURCE_FILE_PATH);
        OutputStream os = new FileOutputStream(PathUtil.SOURCE_FILE_PATH);
        int data = is.read();
        while (data != -1) {
            os.write(data);
            data = is.read();
        }
        is.close();
        os.close();
        System.out.println("Finished: " + LocalDateTime.now());
    }
    
    private static void bufferedIoDemo() throws IOException {
        System.out.println("Started: " + LocalDateTime.now());
        InputStream is = new BufferedInputStream(
                new FileInputStream(PathUtil.SOURCE_FILE_PATH)
        );

        OutputStream os = new BufferedOutputStream(
                new FileOutputStream(PathUtil.SOURCE_FILE_PATH)
        );

        int data = is.read();
        while (data != -1) {
            os.write(data);
            data = is.read();
        }
        is.close();
        os.close();
        System.out.println("Finished: " + LocalDateTime.now());
    }
}
