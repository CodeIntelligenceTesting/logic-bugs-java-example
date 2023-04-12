import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;

public class XMLEncodeDecodeTest {
    @FuzzTest
    public void roundTrip(FuzzedDataProvider data){
        Person testInput = new Person(data.consumeAsciiString(8), data.consumeInt());
        XMLUtilities utils = new XMLUtilities();

        Assertions.assertEquals(testInput, utils.XMLtoPerson(utils.personToXML(testInput)));
    }
}
