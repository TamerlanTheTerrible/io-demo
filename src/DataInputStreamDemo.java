import java.io.*;

/**
 * Created by Temurbek Ismoilov on 09/03/23.
 */

public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //create file
        File file = new File("../source-file2.rtf");
        if (!file.exists()) {
            file.createNewFile();
        }
        //write data
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file));
        outputStream.writeBoolean(true);
        outputStream.writeDouble(2.0);
        outputStream.writeInt(2);
        outputStream.close();
        //read data
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        boolean b = inputStream.readBoolean();
        double d = inputStream.readDouble();
        int i = inputStream.readInt();
        inputStream.close();
        //print results
        System.out.println(b);
        System.out.println(d);
        System.out.println(i);
    }
}
