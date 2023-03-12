import java.io.*;

/**
 * Created by Temurbek Ismoilov on 07/03/23.
 */

public class PipeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedOutputStream output = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(output);

        Thread thread1 = new Thread(() -> {
            try {
                output.write("Hello from pype".getBytes());
                output.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int data = input.read();
                while (data != -1) {
                    System.out.print((char)data);
                    data = input.read();
                }
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
