package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Hangman {

    Set<String> usedWordsSet = new HashSet<>();

    public int countAlphabetLetters(String word, char alphabet) {

        int lettersInWord = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == alphabet) {
                lettersInWord++;
            }
        }

        return lettersInWord;
    }

    public String fetchWord() {
        return "pizza";
    }

    public String fetchWord(int requestedLength) {
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader("WordSource.txt"))) {
            while ((result = br.readLine()) != null)
                if (result.length() != requestedLength) continue;
                else if (usedWordsSet.add(result)) break;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
