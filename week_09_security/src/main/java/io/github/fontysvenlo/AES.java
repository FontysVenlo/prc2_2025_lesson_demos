package io.github.fontysvenlo;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Taken from Cay Horstmann
 */
public class AES {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, ClassNotFoundException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (args.length < 2) {
            System.out.println("Usage: java -jar AES.jar --genkey secret.key");
            System.out.println("Usage: java -jar AES.jar -encrypt plaintextfile encryptedfile key");
            System.out.println("Usage: java -jar AES.jar -decrypt encryptedfile plaintextfile key");
            System.exit(1);
        }
        if(args[0].equals("-genkey")) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            var random = new SecureRandom();
            keyGenerator.init(random);
            SecretKey secretKey = keyGenerator.generateKey();
            try(var out = new ObjectOutputStream(new FileOutputStream(args[1]))) {
                out.writeObject(secretKey);
            }
        }else{
            int mode = Cipher.DECRYPT_MODE;
            if(args[0].equals("-encrypt")) {
                mode = Cipher.ENCRYPT_MODE;
            }

            try(
                    var keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                    var in = new FileInputStream(args[1]);
                    var out = new FileOutputStream(args[2]);
            ) {
                var key = (Key) keyIn.readObject();
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(mode, key);
                Util.crypt(in, out, cipher);
            }
        }
    }
}