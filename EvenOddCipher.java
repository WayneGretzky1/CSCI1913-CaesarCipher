// CSCI 1913 Fall 2022 Project 2
// Author: Brock Bye
//CSCI 1913 Fall 2022
//Author: Brock Bye

/**
 * Even Odd Cipher is a “Scramble” cipher, that disguises text by shuffling the letters up. The
 * idea is quite simple, first list all the even letters, then list all the odd letters.
 */
public class EvenOddCipher extends BaseCipher{


    /**
     * A public constructor that is used for the inheritance of the BaseCipher class
     */
    public EvenOddCipher (){
        super ("EvenOddCipher");
    }


    /**
     *  A public method that returns a String, the result of applying the
     * even odd cipher to the input.
     * @param s
     * @return encryptS
     */
    @Override
    public String encrypt(String s) {
        String encryptS = "";
        String even = "";
        String odd = "";

        for (int i=0; i < s.length(); i++) {
            //Checks if current index is even
            if ((i%2) == (0)) {
                even += s.charAt(i);
            }
            else {
                odd += s.charAt(i);
            }
        }
        encryptS += even;
        encryptS += odd;


        return encryptS;
    }


    /**
     *  A public method that returns a String, the result of reversing the
     * even odd cipher on the input.
     * @param s
     * @return decryptS
     */
    @Override
    public String decrypt(String s) {
        String decryptS = "";
        int midpoint = (s.length()/2);

        //Intuition here is that there will always be more even indexes than odds, when s is an odd s.length().
        //In the case that s.length() is odd, then even string needs to be one longer than odd.
        if (s.length()%2 == 1) {
            midpoint += 1;
        }

        //Returns a string that is a substring of this string. (beginIndex is inclusive, endIndex is exclusive)
        String even = s.substring(0, midpoint);
        String odd = s.substring(midpoint, s.length());

        for (int i=0; i < midpoint; i++) {
            if (i == midpoint - 1) {
                //In the case that even string is one longer than odd string, even needs to concatenate once more.
                if (even.length() > odd.length()) {
                    decryptS += even.charAt(i);
                    return decryptS;
                }
            }
            decryptS += even.charAt(i);
            decryptS += odd.charAt(i);
        }


        return decryptS;
    }

    /**
     *  A public method that returns a String, which describes the object, the
     * format for this must match what is seen in the tests
     * @return
     */
    @Override
    public String toString(){return "EvenOddCipher";}

    /**
     *  A public method that returns a boolean, which is true if it is passed
     * a another EvenOddCipher.
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

        else if (other instanceof EvenOddCipher) {
            return true;
        }

        else {
            return false;
        }
    }
}

