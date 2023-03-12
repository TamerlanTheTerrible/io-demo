import java.io.Serializable;

/**
 * Created by Temurbek Ismoilov on 10/03/23.
 */

public class TestClass implements Serializable {
    public int testInt;
    public String testString;
    public transient String notSerializableString;

    @Override
    public String toString() {
        return "TestClass{" +
                "testInt=" + testInt +
                ", testString='" + testString + '\'' +
                ", notSerializableString='" + notSerializableString + '\'' +
                '}';
    }
}
