// CSCI 1913 Fall 2022 Project 2
// Author: Brock Bye
//CSCI 1913 Fall 2022
//Author: Brock Bye

/**
 * This class has two static methods that handle repeated encryption or decryption over sequences of strings.
 */
public class EncryptUtils {
    /**
     *  A public static function which takes a BaseCipher variable (which of course may be any subtype as well), and an array of strings.
     *  The function should return a new array of strings that is the result of encrypting each String using the cipher.
     *  The input array should remain unchanged.
     * @param cipher
     * @param toBeEncrypt
     * @return encryptArrayS
     */
    public static String[] encryptMany(BaseCipher cipher, String[] toBeEncrypt) {
        String[] encryptArrayS = new String[toBeEncrypt.length];

        for (int i=0; i < toBeEncrypt.length; i++) {
            //Polymorphism allows whatever the current cipher is to use it's own encrypt method.
            encryptArrayS[i] = cipher.encrypt(toBeEncrypt[i]);
        }


        return encryptArrayS;
    }


    /**
     * A public static function which takes a BaseCipher variable (which of course may be any subtype as well), and an array of strings.
     * The function should return a new array of strings that is the result of decrypting each String using the cipher.
     * The input array should remain unchanged.
     * @param cipher
     * @param toBeDecrypt
     * @return decryptArrayS
     */
    public static String[] decryptMany(BaseCipher cipher, String[] toBeDecrypt) {
        String[] decryptArrayS = new String[toBeDecrypt.length];

        for (int i=0; i < toBeDecrypt.length; i++) {
            //Polymorphism allows whatever the current cipher is to use it's own decrypt method.
            decryptArrayS[i] = cipher.decrypt(toBeDecrypt[i]);
        }


        return decryptArrayS;
    }
}
