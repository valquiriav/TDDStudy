package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hangman {

    Set<String> usedWordsSet = new HashSet<>();
    List<String> wordsList = new ArrayList<>();

    public int countAlphabetLetters(String word, char alphabet) {

        int lettersInWord = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == alphabet) {
                lettersInWord++;
            }
        }

        return lettersInWord;
    }

    public String fetchWord(int requestedLength) {
        for (String result : wordsList) {
            if (result.length() != requestedLength) continue;
            else if (usedWordsSet.add(result)) return result;
        }
        return null;

    }


    public void loadWords() {
        String word = null;
        try (BufferedReader br = new BufferedReader(new FileReader("WordSource.txt"))) {
            while ((word = br.readLine()) != null) {
                wordsList.add(word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //this is before a player's guess
    public String fetchClue(String word) {
        //get word length
        int wordLength = word.length();
        //create clue string
        StringBuilder clue = new StringBuilder();

        //loop to add _
        for (int i = 0; i < wordLength; i++) {
            clue = clue.append("_");
        }

        //turns StringBuilder into String
        return clue.toString();
    }

    //after player's guess, this method is called to check whether the guess is correct
    public boolean checkGuess(String word, char guess) {
        //checks if there is a char in word and returns true or false
        return word.contains(Character.toString(guess));
    }

    //if guess is correct, return clue word with dashes replaced
    public String correctGuess(String word, char guess) {
        //create new clue variable
        String newClue = "____a";
        return newClue;
    }

    //if guess is incorrect, return message

}