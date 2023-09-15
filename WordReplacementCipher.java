// CSCI 1913 Fall 2022 Project 2
// Author: Brock Bye
//CSCI 1913 Fall 2022
//Author: Brock Bye

/**
 * The word replacement cipher is relatively simple, it swaps each occurrence of one word for a pre-chosen replacement.
 */
public class WordReplacementCipher extends BaseCipher{
    private String From;
    private String To;


    /**
     * Public constructor that takes two parameters, both strings, representing the word to replace from, and the word to replace to.
     * The constructor is also used for the inheritance of the BaseCipher class.
     * @param From
     * @param To
     */
    public WordReplacementCipher(String From, String To) {
        super ("WordReplacementCipher");
        this.From = From;
        this.To = To;
    }


    /**
     * A public method that returns a String, the result of applying the
     * word replacement to the input.
     * @param s
     * @return
     */
    @Override
    public String encrypt(String s) {return s.replace(From, To);}
    //Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.


    /**
     * Note, decrypting is simply the opposite of encrypting.
     *  A public method decrypt(String) that returns a String, the result of reversing the
     * word replacement on the input.
     * @param s
     * @return
     */
    @Override
    public String decrypt(String s) {
        return s.replace(To, From);
    }
    //Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.


    /**.
     *  A public method toString() that returns a String, which describes the object.
     *  WordReplacementCipher(al, be)
     */
    @Override
    public String toString(){
        return "WordReplacementCipher(" + From + ", " + To +")";
    }


    /**
     *  A public method equals(Object) that returns a boolean, which is true if it is passed
     * a another WordReplacement cipher with the same from and to words.
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

        else if (other instanceof WordReplacementCipher) {
            //Create a new WordReplacementCipher object out of other, then compare their From's & To's string literals.
            WordReplacementCipher cipher = (WordReplacementCipher) other;
            return ((cipher.From == this.From) && (cipher.To == this.To));
        }

        else {
            return false;
        }
    }
}

