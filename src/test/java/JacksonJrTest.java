import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class JacksonJrTest {

    @FuzzTest
    public void roundTripJSON(FuzzedDataProvider data) throws IOException  {
        JacksonJrUtilities util = new JacksonJrUtilities();
        String testValue = data.consumeString(16);
        Object obj = util.stringToObject(testValue);
        Assertions.assertEquals(testValue, util.objectToString(obj));
    }
}
