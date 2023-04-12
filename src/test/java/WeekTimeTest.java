import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class WeekTimeTest {

    @FuzzTest
    public void fuzzyCase(FuzzedDataProvider data){
        LocalDate dateNow = LocalDate.now();
        LocalDate dateLater = LocalDate.now();

        dateLater.plusDays(data.consumeLong(0L, 100L));

        // Use the Joda-Time .compareTo method to determine if dateNow is "before" dateLater as expected
        Assertions.assertTrue(dateNow.compareTo(dateLater) < 0);
    }
}
