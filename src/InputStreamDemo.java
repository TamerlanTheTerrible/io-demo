import util.InputStreamProcessingTemplate;
import util.InputStreamProcessor;
import util.PathUtil;

import java.io.*;
import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */

public class InputStreamDemo {
    public static void main(String[] args) {
        InputStreamProcessingTemplate.process(PathUtil.SOURCE_FILE_PATH, "READ BY BYTE", input -> {
            int data = input.read();
            while (data != -1) {
                data = input.read();
            }
        });

        InputStreamProcessingTemplate.process(PathUtil.SOURCE_FILE_PATH, "READ BY ARRAY", input -> {
            byte[] bytes = new byte[1024];
            int data = input.read(bytes);
            while (data != -1) {
                data = input.read(bytes);
            }
        });

        InputStreamProcessingTemplate.process(PathUtil.SOURCE_FILE_PATH, "READ ALL", InputStream::readAllBytes);

        InputStreamProcessingTemplate.process(PathUtil.SOURCE_FILE_PATH, "BUFFERED READ", input -> new BufferedInputStream(input).readAllBytes());
        
    }

    private static void readDemo(String testText, Consumer<InputStream> consumer) {
        System.out.println(testText);
        try (InputStream inputStream = new FileInputStream(PathUtil.SOURCE_FILE_PATH);){
            System.out.println("start: " + LocalDateTime.now());
            consumer.accept(inputStream);
            System.out.println("finish: " + LocalDateTime.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(byte[] bytes) {
        for(Byte b: bytes) {
            System.out.print((char)(int)b);
        }
    }
}
