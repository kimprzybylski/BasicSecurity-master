import hybrid.encrypt.EncryptData;
import hybrid.encrypt.EncryptKey;
import hybrid.encrypt.StartEncryption;
import keypair.GenerateKeys;
import onekey.GenerateSymmetricKey;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * Created by kimprzybylski on 22/03/17.
 */
public class AppCryptoProgram extends Component {
    public static void main(String[] args) throws Exception {
        /*Scanner sc = new Scanner(System.in);
        GenerateKeys gk_Alice;
        GenerateKeys gk_Bob;

        // Programma vraagt keuze te maken tussen encrypteren of decrypteren
        System.out.println("Encrypteren of Decrypteren?");
        String method = sc.next();

        //encrypteren
        if(method.equals("Encrypteren")) {
            // Genereer 1 semmetrische key(AES)
            GenerateSymmetricKey generateSymmetricKey = new GenerateSymmetricKey(16, "AES");
            generateSymmetricKey.writeToFile("OneKey/secretKey", generateSymmetricKey.getKey().getEncoded());

            // Genereer private en public RSA key voor Alice en Bob
            gk_Alice = new GenerateKeys(1024);
            gk_Alice.createKeys();
            gk_Alice.writeToFile("KeyPair/publicKey_Alice", gk_Alice.getPublicKey().getEncoded());
            gk_Alice.writeToFile("KeyPair/privateKey_Alice", gk_Alice.getPrivateKey().getEncoded());

            gk_Bob = new GenerateKeys(1024);
            gk_Bob.createKeys();
            gk_Bob.writeToFile("KeyPair/publicKey_Bob", gk_Bob.getPublicKey().getEncoded());
            gk_Bob.writeToFile("KeyPair/privateKey_Bob", gk_Bob.getPrivateKey().getEncoded());

            // Programma vraagt input aan Alice (bv. een boodschap om door te sturen)
            System.out.println("Selecteer een bestand met boodschap.");

            // Programma gebruikt de symmetric key om de boodschap te encrypteren, en saved het resultaat in een file (File_1)
            StartEncryption startEnc = new StartEncryption();

            File originalFile = new File("Test.rtf");
            File encryptedFile = new File("EncryptedFiles/File_1");
            new EncryptData(originalFile, encryptedFile,
                    startEnc.getSecretKey("OneKey/secretKey", "AES"), "AES");

            // Programma encrypteert de symmetric key met de public key van Bob, en saved het resultaat in een file (File_2)
            File originalKeyFile = new File("OneKey/secretKey");
            File encryptedKeyFile = new File("EncryptedFiles/File_2");
            new EncryptKey(startEnc.getPublic("KeyPair/publicKey_Bob", "RSA"),
                    originalKeyFile, encryptedKeyFile, "RSA");

            // Programma maakt een hash van de oorspronkelijke boodschap
            //Programma encrypteert die hash met de private key van Alice, en saved het resultaat in een file (File_3)
        }*/

    }
}
