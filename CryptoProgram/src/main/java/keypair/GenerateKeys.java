package keypair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

/**
 * Created by kimprzybylski on 15/03/17.
 */
public class GenerateKeys {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        this.keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        this.keyPairGenerator.initialize(keylength);
    }

    public void createKeys()
    {
        this.keyPair = this.keyPairGenerator.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
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
