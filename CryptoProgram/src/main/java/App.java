import hybrid.encrypt.EncryptData;
import hybrid.encrypt.EncryptKey;
import hybrid.encrypt.StartEncryption;
import keypair.GenerateKeys;
import onekey.GenerateSymmetricKey;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by kimprzybylski on 15/03/17.
 */
public class App {
    public static void main(String[] args) throws Exception {
        /*Scanner sc = new Scanner(System.in);
        GenerateKeys gk_Alice;
        GenerateKeys gk_Bob;


        System.out.println("Encrypteren of Decrypteren");
        String methode = sc.next();

        //if(methode.equals("Encrypteren")){
            // Generate Symmetric Key
            GenerateSymmetricKey generateSymmetricKey = new GenerateSymmetricKey(16, "AES");
            generateSymmetricKey.writeToFile("OneKey/secretKey", generateSymmetricKey.getKey().getEncoded());

            // Generate Public and Private Key
            gk_Alice = new GenerateKeys(1024);
            gk_Alice.createKeys();
            gk_Alice.writeToFile("KeyPair/Public_A", gk_Alice.getPublicKey().getEncoded());
            gk_Alice.writeToFile("KeyPair/Private_A", gk_Alice.getPrivateKey().getEncoded());

            gk_Bob = new GenerateKeys(1024);
            gk_Bob.createKeys();
            gk_Bob.writeToFile("KeyPair/Public_B", gk_Bob.getPublicKey().getEncoded());
            gk_Bob.writeToFile("KeyPair/Private_B", gk_Bob.getPrivateKey().getEncoded());

            // Create message
            System.out.println("Schrijf uw boodschap");
            String message = sc.next();
            PrintWriter out = new PrintWriter("Message.txt");
            out.println(message);

            // Create File objects
            StartEncryption startEnc = new StartEncryption();

            File originalKeyFile = new File("OneKey/secretKey");
            File encryptedKeyFile = new File("EncryptedFiles/encryptedSecretKey");
            new EncryptKey(startEnc.getPublic("KeyPair/publicKey_Bob", "RSA"), originalKeyFile, encryptedKeyFile, "RSA");

            File originalFile = new File("confidential.txt");
            File encryptedFile = new File("EncryptedFiles/encryptedFile");
            new EncryptData(originalFile, encryptedFile, startEnc.getSecretKey("OneKey/secretKey", "AES"), "AES");
        }
        else {

        }*/
    }
}
