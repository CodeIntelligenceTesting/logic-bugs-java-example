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

        Assertions.assertTrue(dateNow.compareTo(dateLater) < 0);
    }
}
