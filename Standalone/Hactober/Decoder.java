package Standalone.Hactober;

import java.util.Base64;

public class Decoder {
    public static void decode(String input) {
        String decodedBase64 = decodeBase64(input);
        System.out.println("Decoded Base64: " + decodedBase64);
       // String decodedHex = decodeHex(input);
       // System.out.println("Decoded Hexadecimal: " + decodedHex);
    }

    public static String decodeBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }

    public static String decodeHex(String encodedString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i += 2) {
            String hexPair = encodedString.substring(i, i + 2);
            int decimalValue = Integer.parseInt(hexPair, 16);
            result.append((char) decimalValue);
        }
        return result.toString();
    }

//    public static String decodeBase32(String encodedString) {
//        Base32 base32 = new Base32();
//        byte[] decodedBytes = base32.decode(encodedString);
//        return new String(decodedBytes);
//    }
}

