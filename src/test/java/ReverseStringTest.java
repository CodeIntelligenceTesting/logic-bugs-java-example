import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;

public class ReverseStringTest {

    @FuzzTest
    public void differentialTest(FuzzedDataProvider data){
        String testInput = data.consumeString(16);

        String output1 = StringUtilities.myReverseString(testInput);
        String output2 = new StringBuilder(testInput).reverse().toString();

        Assertions.assertEquals(output1, output2);
    }
}
