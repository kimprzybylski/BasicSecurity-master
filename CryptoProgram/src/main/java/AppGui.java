import hybrid.encrypt.EncryptData;
import hybrid.encrypt.EncryptKey;
import hybrid.encrypt.StartEncryption;
import keypair.GenerateKeys;
import onekey.GenerateSymmetricKey;

import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by kimprzybylski on 22/03/17.
 */
public class AppGui {
    private JButton buttonEncrypt;
    private JButton buttonDecrypt;
    private JPanel panel;
    private JButton buttenDecrypt;

    public AppGui() {

        buttonEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Genereer 1 semmetrische key(AES)
                GenerateSymmetricKey generateSymmetricKey = null;
                try {
                    generateSymmetricKey = new GenerateSymmetricKey(16, "AES");
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (NoSuchPaddingException e1) {
                    e1.printStackTrace();
                }
                try {
                    generateSymmetricKey.writeToFile("OneKey/secretKey", generateSymmetricKey.getKey().getEncoded());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // Genereer private en public RSA key voor Alice en Bob
                GenerateKeys gk_Alice = null;
                GenerateKeys gk_Bob = null;
                try {
                    gk_Alice = new GenerateKeys(1024);
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (NoSuchProviderException e1) {
                    e1.printStackTrace();
                }
                gk_Alice.createKeys();
                try {
                    gk_Alice.writeToFile("KeyPair/publicKey_Alice", gk_Alice.getPublicKey().getEncoded());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    gk_Alice.writeToFile("KeyPair/privateKey_Alice", gk_Alice.getPrivateKey().getEncoded());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    gk_Bob = new GenerateKeys(1024);
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (NoSuchProviderException e1) {
                    e1.printStackTrace();
                }
                gk_Bob.createKeys();
                try {
                    gk_Bob.writeToFile("KeyPair/publicKey_Bob", gk_Bob.getPublicKey().getEncoded());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    gk_Bob.writeToFile("KeyPair/privateKey_Bob", gk_Bob.getPrivateKey().getEncoded());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // Programma vraagt input aan Alice (bv. een boodschap om door te sturen)
                System.out.println("Selecteer een bestand met boodschap.");

                // Programma gebruikt de symmetric key om de boodschap te encrypteren, en saved het resultaat in een file (File_1)
                StartEncryption startEnc = new StartEncryption();

                File originalFile = new File("Test.rtf");
                File encryptedFile = new File("EncryptedFiles/File_1");
                try {
                    new EncryptData(originalFile, encryptedFile,
                            startEnc.getSecretKey("OneKey/secretKey", "AES"), "AES");
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (GeneralSecurityException e1) {
                    e1.printStackTrace();
                }

                // Programma encrypteert de symmetric key met de public key van Bob, en saved het resultaat in een file (File_2)
                File originalKeyFile = new File("OneKey/secretKey");
                File encryptedKeyFile = new File("EncryptedFiles/File_2");
                try {
                    new EncryptKey(startEnc.getPublic("KeyPair/publicKey_Bob", "RSA"),
                            originalKeyFile, encryptedKeyFile, "RSA");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                // Programma maakt een hash van de oorspronkelijke boodschap
                //Programma encrypteert die hash met de private key van Alice, en saved het resultaat in een file (File_3)
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crypto Program");
        frame.setContentPane(new AppGui().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
