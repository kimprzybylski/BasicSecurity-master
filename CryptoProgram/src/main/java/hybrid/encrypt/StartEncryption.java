package hybrid.encrypt;

import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by kimprzybylski on 15/03/17.
 */
public class StartEncryption
{
    public PrivateKey getPrivate(String fileName, String algorithm) throws Exception
    {
        byte[] keyBytes = Files.readAllBytes(new File(fileName).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePrivate(spec);
    }

    public PublicKey getPublic(String fileName, String algorithm) throws Exception
    {
        byte[] keyBytes = Files.readAllBytes(new File(fileName).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(spec);
    }

    public SecretKeySpec getSecretKey(String fileName, String algorithm) throws IOException
    {
        byte[] keyBytes = Files.readAllBytes(new File(fileName).toPath());
        return new SecretKeySpec(keyBytes, algorithm);
    }
}
