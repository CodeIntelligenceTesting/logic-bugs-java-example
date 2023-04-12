import com.fasterxml.jackson.jr.ob.JSON;

import java.io.IOException;
import java.util.Map;

/**
 * Utility class containing JSON processing functionality
 * based on the Jackson Jr library
 * <link>: <a href="https://github.com/FasterXML/jackson-jr">Jackson Jr</a>
 */
public class JacksonJrUtilities {

    public Object stringToObject(String input) throws IOException {
        return JSON.std.mapFrom(input);
    }

    public String objectToString(Object input) throws IOException {
        return JSON.std.asString(input);
    }

}
