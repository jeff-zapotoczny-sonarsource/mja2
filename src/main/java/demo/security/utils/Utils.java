package demo.security.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {

    private Random rando;

    public Utils() {
        this.rando = new Random();
    }

    public KeyPair makeKey() {
        KeyPairGenerator keyPairGen;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(512);
            return keyPairGen.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public byte[] generateRandomBytes() {
        byte[] bytes = new byte[20];
        rando.nextBytes(bytes);
        return bytes;
    }
}
