import org.example.Hangman;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestHangman {

    @Test
    void test_alphabetCountInAWord() {
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();

        int wordCount = hangman.countAlphabetLetters(word, alphabet);

        assertEquals(wordCount, 1);

    }

    @Test
    void test_lengthOfFetchedWord() {
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord();

        assertTrue(word.length() == 5);
    }

    @Test
    void test_lengthOfFetchedWordRandom() {
        Random random = new Random();
        int requestedLength = random.nextInt(6) + 5;
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord(requestedLength);

        assertTrue(requestedLength == word.length());
    }

    @Test
    void test_uniquenessOfFetchedWord() {
        //get random number
        Random random = new Random();
        //store random number
        int requestedLength = 0;

        //create HashSet
        Set<String> usedWordsSet = new HashSet<>();

        //counter for number of rounds before word can be repeated
        int round = 0;

        //store the word
        String word = null;

        //instantiate Hangman
        Hangman hangman = new Hangman();

        while (round < 100) {
            requestedLength = random.nextInt(6) + 5;
            word = hangman.fetchWord(requestedLength);
            round++;
            assertTrue(usedWordsSet.add(word));
        }
    }
}