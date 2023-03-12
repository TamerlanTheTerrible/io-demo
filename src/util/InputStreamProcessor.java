package util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Temurbek Ismoilov on 08/03/23.
 */

public interface InputStreamProcessor {
    void process(InputStream input) throws IOException;
}

