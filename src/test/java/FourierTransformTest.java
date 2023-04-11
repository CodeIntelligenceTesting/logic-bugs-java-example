import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.tambapps.fft4j.FastFouriers;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class FourierTransformTest {
    @FuzzTest
    public void differentialTest(FuzzedDataProvider data) throws IOException {
        double[] inputsRe = new double[16];
        double[] inputsIm = new double[16];

        for(int i = 0; i < 16; i++){
            inputsRe[i] = data.consumeDouble();
            inputsIm[i] = data.consumeDouble();
        }

        FastFouriers.BASIC.transform(inputsRe, inputsIm);
        FastFouriers.BEST.transform(inputsRe, inputsIm);
    }

}
