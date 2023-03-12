package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */



public class InputStreamProcessingTemplate {

    public static void process(String fileName, String text, InputStreamProcessor processor) {
        System.out.println(text);
        IOException processException = null;
        InputStream input = null;
        try {
            input = new FileInputStream(fileName);
            System.out.println("start: " + LocalDateTime.now());
            processor.process(input);
            System.out.println("finish: " + LocalDateTime.now());
        } catch (IOException e) {
            processException = e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    if (processException != null) {
                        throw new RuntimeException(processException);
                    } else {
                        throw new RuntimeException(processException);
                    }
                }
            }
            if (processException != null) {
                throw new RuntimeException(processException);
            }
        }
    }
}