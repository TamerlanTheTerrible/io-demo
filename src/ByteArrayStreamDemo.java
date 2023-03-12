import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */

public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {
        //write data to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("hello from ByteArrayOutputStream".getBytes(StandardCharsets.UTF_8));
        final byte[] bytes = outputStream.toByteArray();

        //read the array
        InputStream input = new ByteArrayInputStream(bytes);
        int data = input.read();
        while (data != -1) {
            System.out.print((char)data);
            data = input.read();
        }
    }
}
