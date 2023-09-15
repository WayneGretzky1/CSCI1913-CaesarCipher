// CSCI 1913 Fall 2022 Project 2
// Author: Brock Bye
//CSCI 1913 Fall 2022
//Author: Brock Bye

/**
 * The SuperCipher class itself will not actually be in charge of doing much encryption, instead
 * it’s job is to arrange other ciphers to encrypt the text (in the right order).
 *  Note, due to polymorphism, this array (SuperCipher) can store any object that is a subtype of BaseCipher.
 */
public class SuperCipher extends BaseCipher{
    private BaseCipher[] cipherArray;


    /**
     * A public constructor that takes one parameter, an array of type BaseCipher indicating which ciphers and in which order this SuperCipher should use.
     * The constructor is also used for the inheritance of the BaseCipher class.
     * @param cipherArray
     */
    public SuperCipher(BaseCipher[] cipherArray) {
        super ("SuperCipher");
        this.cipherArray = cipherArray;
    }


    /**
     *  A public method which returns a boolean. A SuperCipher is valid if, and only if, each base cipher is valid.
     * @return
     */
    @Override
    public boolean isValid() {
        int Counter = 0;
        for (int i=0; i < cipherArray.length; i++) {
            if (cipherArray[i].isValid()) {
                Counter += 1;
            }
        }

        if (Counter == cipherArray.length) {
            return true;
        }
        return false;
    }


    /**
     *  A public method which returns a String, the result of applying each cipher provided to the constructor, in the order provided.
     * @param s
     * @return encryptS
     */
    @Override
    public String encrypt(String s) {
        String encryptS = "";

        for (BaseCipher cipher: cipherArray) {
            encryptS = cipher.encrypt(s);
            s = encryptS;
        }


        return encryptS;
    }


    /**
     *  A public method decrypt(String) which returns a String, the result of reversing each cipher provided to the constructor, in the correct order.
     * @param s
     * @return decryptS
     */
    @Override
    public String decrypt(String s) {
        String decryptS = "";

        for (int i=cipherArray.length - 1; i >= 0; i--) {
            decryptS = cipherArray[i].decrypt(s);
            s = decryptS;
        }
//        for (BaseCipher cipher: cipherArray) {
//            decryptS = cipher.decrypt(s);
//            s = decryptS;
//        }


        return decryptS;
    }


    /**
     *  A public method which returns a String.
     *  SuperCipher(Caesar(1) | Caesar(100) | EvenOddCipher)
     * @return
     */
    @Override
    public String toString() {
        String myToString = "SuperCipher(";
        for (int i=0; i < cipherArray.length; i++) {
            if (i == cipherArray.length - 1) {
                myToString += cipherArray[i].toString() + ")";
            }
            else {
                myToString += cipherArray[i].toString() + " | ";
            }
        }


        return myToString;
    }


    /**
     *  A public method which returns a boolean.
     *  A SuperCipher is equal to another SuperCipher if and only if it’s chain of ciphers match
     *  (I.E. are the same length, and are equal at each position).
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

        else if (other instanceof SuperCipher) {
            SuperCipher cipher = (SuperCipher) other;

            if (cipherArray.length != cipher.cipherArray.length) {
                return false;
            }

            int Counter = 0;
            for (int i=0; i < cipherArray.length; i++) {
                if (cipherArray[i].equals(cipher.cipherArray[i])) {
                    Counter += 1;
                }
            }

            if (Counter == cipherArray.length) {
                return true;
            }
            return false;

        }

        else {
            return false;
        }
    }
}
