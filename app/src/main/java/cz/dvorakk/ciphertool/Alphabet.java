package cz.dvorakk.ciphertool;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds used alphabet with its settings
 * and performs basic letter shift operation
 */
public class Alphabet {
    private String alphabet;
    private int alphabetLength;
    private int aIndex;
    private Map<Character, Integer> charToIndexMap = new HashMap<Character, Integer>(alphabetLength);
    private Map<Integer, Character> indexToCharMap = new HashMap<Integer, Character>(alphabetLength);

    public Alphabet(int aIndex) {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", aIndex);
    }

    public Alphabet(String alphabet, int aIndex) {
        this.aIndex = aIndex;
        this.alphabet = alphabet;
        alphabetLength = alphabet.length();

        for (int i = 0; i < alphabetLength; i++) {
            char ch = alphabet.charAt(i);
            charToIndexMap.put(ch, i + aIndex);
            indexToCharMap.put(i + aIndex, ch);
        }
    }

    public String getAlphabet() {
        return alphabet;
    }

    public int getLength() {
        return alphabetLength;
    }

    public Character getCharByIndex(int index) {
        return indexToCharMap.get(index);
    }

    public Integer getIndexByChar(Character character) {
        return charToIndexMap.get(character);
    }

    public String removeUnknownChars(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charToIndexMap.keySet().contains(ch))
                sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * Shifts given letter by given shift
     * @param letterIndex letter index in this alphabet
     * @param shift number of positions to shift
     * @param positive true for positive shift, false for negative
     * @return index of the resulting letter in this alphabet
     */
    public int shiftAsIndex(int letterIndex, int shift, boolean positive) {
        int shifted = positive ? letterIndex + shift : letterIndex - shift;
        while (shifted <= 0) shifted += alphabetLength;
        return ((shifted - aIndex) % alphabetLength) + aIndex;
    }

    public Character shiftAsChar(int first, int second, boolean encode) {
        return getCharByIndex(shiftAsIndex(first, second, encode));
    }
}
