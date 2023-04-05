import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;

/**
 * Example of a logical test verifying the <a href="https://en.wikipedia.org/wiki/Triangle_inequality">Triangle inequality</a>
 * using generated values from the Fuzzed Data provider
 */
public class TriangleInequalityTest {

    @FuzzTest
    public void verifyInequality(FuzzedDataProvider data){
        Double x = 1.0;
        Double y = data.consumeDouble();

        Double leftSide = Math.abs(x + y);
        Double rightSide = Math.abs(x) + Math.abs(y);

        Assertions.assertTrue(leftSide <= rightSide);
    }
}
