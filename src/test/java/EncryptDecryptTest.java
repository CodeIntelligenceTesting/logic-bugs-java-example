import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptDecryptTest {

    @FuzzTest
    public void testRoundTrip(FuzzedDataProvider data) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
    BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        CryptoUtils utils = new CryptoUtils();

        String input = data.consumeRemainingAsString();
        SecretKey key = utils.generateKey(128);
        IvParameterSpec ivParameterSpec = utils.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        String cipherText = utils.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = utils.decrypt(algorithm, cipherText, key, ivParameterSpec);
        Assertions.assertEquals(input, plainText);
    }
}
