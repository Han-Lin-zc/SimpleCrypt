package rocks.zipcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ROT13 {

    Integer shift;
    ROT13(Character cs, Character cf) {
        shift = cf - cs;
    }

    ROT13() {
        shift = 13;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        StringBuffer result = new StringBuffer();
        char temp = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current < 65 || current > 122 || (current < 97 && current > 90)) {
                temp = text.charAt(i);
            } else if (Character.isUpperCase(current)) {
                temp = (char) (((current + this.shift - 65) % 26) + 65);
            } else if (Character.isLowerCase(current)) {
                temp = (char) (((current + this.shift - 97) % 26) + 97);
            }
            result.append(temp);
            temp = 0;
        }
        return result.toString();
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {
        String rotated = s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                rotated = s.substring(i) + s.substring(0, i);
            }
        }
        return rotated;
    }

    public void encryptTextFile(File file) throws IOException {
        String nonEncrypt = new Scanner(file)
                .useDelimiter("\\Z").next();
        File encrypted = new File("/Users/hlin/Documents/Projects/Labs.Month.Two/SimpleCrypt/Crypto/src/resource/sonnet18.enc");
        shift = 13;
        FileWriter writer = new FileWriter(encrypted);
        writer.write(encrypt(nonEncrypt));
        writer.close();
    }
}
