import java.io.*;

/**
 * Created by Temurbek Ismoilov on 10/03/23.
 */

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //create file
        File file = new File("./object.data");
        if (!file.exists()) {
            file.createNewFile();
        }
        //write object
        var objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        var object = new TestClass();
        object.testInt = 15;
        object.testString = "this is a string";
        object.notSerializableString = "this should not be serialized";
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        //read object
        var inputStream = new ObjectInputStream(new FileInputStream(file));
        TestClass deserializedObject = (TestClass) inputStream.readObject();
        inputStream.close();
        //print the result
        System.out.println(deserializedObject);
    }


}
