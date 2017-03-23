package onekey;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by kimprzybylski on 15/03/17.
 */
public class GenerateSymmetricKey {

    private SecretKeySpec secretKeySpec;

    public GenerateSymmetricKey(int length, String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException
    {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[length];
        random.nextBytes(key);
        secretKeySpec = new SecretKeySpec(key, algorithm);
    }

    public SecretKeySpec getKey()
    {
        return secretKeySpec;
    }

    public void writeToFile(String path, byte[] key) throws IOException
    {
        File file = new File(path);
        file.getParentFile().mkdirs();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(key);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
