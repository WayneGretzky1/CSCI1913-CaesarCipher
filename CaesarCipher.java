// CSCI 1913 Fall 2022 Project 2
// Author
//CSCI 1913 Fall 2022
//Author: Brock Bye

/**
 * A CaesarCipher object represents an encrypted version of a message.
 * Each instance of the cipher is defined by the key value – how far it “rotates” around the alphabet.
 * This key value should be a private attribute of the CaesarCipher object, and should be an integer.
 */
public class CaesarCipher extends BaseCipher{
    private int key;


    /**
     *  A public constructor that takes one parameter, (an int) the amount to rotate by.
     *  The constructor is also used for the inheritance of the BaseCipher class.
     * @param key
     */
    public CaesarCipher(int key) {
        super ("CaesarCipher");
        this.key = key;
    }


    /**
     *  A public method isValid() that returns a boolean indicating if the amount to rotate by is valid (between 1 and 25).
     * @return
     */
    @Override
    public boolean isValid() {
        if (key > 0 && key < 26) {
            return true;
        }

        else {
            return false;
        }
    }


    /**
     *  A public method that returns a String, the result of applying a Caesar cipher to the input.
     * @param s String
     * @return encryptS
     */
    @Override
    public String encrypt(String s) {
        s = s.toLowerCase();
        String encryptS = "";

        for (int i=0; i < s.length(); i++) {
            char currC = s.charAt(i);
            //If current character is a letter
            if (Character.isAlphabetic(currC)) {
                int Ascii = (int) currC + key;

                //If current character in ASCII form needs to wrap back around to start of key at 'a'
                if (Ascii > 122) {
                    int wrappedAround = (int) Ascii - (122 - 96);    //Checks if key wraps back around to the start, (z to a)
                    String encryptToString = Character.toString((char) wrappedAround);
                    encryptS += encryptToString;
                }
                else {
                    String encryptToString = Character.toString((char) Ascii);
                    encryptS += encryptToString;
                }

            }
            //If current character is not a letter, don't modify
            else {
                encryptS += Character.toString(s.charAt(i));
            }
        }

        return encryptS;
    }


    /**
     * Note, decrypting is simply the opposite of encrypting. Simply rotate by -key instead of key
     *  A public method decrypt(String) that returns a String, the result of reversing a Caesarcipher on the input.
     * @param s
     * @return  decryptS
     */
    @Override
    public String decrypt(String s) {
        s = s.toLowerCase();
        String decryptS = "";

        for (int i=0; i < s.length(); i++) {
            char currC = s.charAt(i);
            //If current character is a letter
            if (Character.isAlphabetic(currC)) {
                int Ascii = (int) currC - key;

                //If current character in ASCII form needs to wrap back around to start of key at 'a'
                if (Ascii < 97) {
                    int wrappedAround = (int) Ascii + (122 - 96);    //Checks if key wraps back around to the start
                    String encryptToString = Character.toString((char) wrappedAround);
                    decryptS += encryptToString;
                }
                else {
                    String encryptToString = Character.toString((char) Ascii);
                    decryptS += encryptToString;
                }

            }
            //If current character is not a letter, don't modify
            else {
                decryptS += Character.toString(s.charAt(i));
            }
        }

        return decryptS;
    }


    /**.
     * A public method toString() that returns a String, which describes the object.
     * Caesar(<key>)
     */
    @Override
    public String toString(){return "Caesar(" + key + ")";}


    /**
     * A public method equals(Object) that returns a boolean, which is true if it is passed
     * a another Caesar cipher with the same rotation amount, and false in all other circumstances.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        else if (other == null) {
            return false;
        }

        else if (other instanceof CaesarCipher) {
            //Create new CaesarCipher object out of other, then compare their key's int value
            CaesarCipher cipher = (CaesarCipher) other;
            return (cipher.key == this.key);
        }

        else {
            return false;
        }
    }
}

