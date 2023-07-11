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
    void test_lengthOfFetchedWordRandom() {
        Random random = new Random();
        int requestedLength = random.nextInt(6) + 5;
        Hangman hangman = new Hangman();
        hangman.loadWords();
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

        hangman.loadWords();

        while (round < 100) {
            requestedLength = random.nextInt(6) + 5;
            word = hangman.fetchWord(requestedLength);
            round++;
            assertTrue(usedWordsSet.add(word));
        }
    }

    @Test
    void test_fetchClue() {

        //get random number
        Random random = new Random();

        //store random number
        int requestedLength = 0;

        //generates random number
        requestedLength = random.nextInt(6) + 5;

        //instantiate hangman
        Hangman hangman = new Hangman();

        //loads words
        hangman.loadWords();

        //creates word variable using fetchWord() method and random number
        String word = hangman.fetchWord(requestedLength);

        //creates clue variable using fetchClue() method and fetched word
        String clue = hangman.fetchClue(word);

        //gets word length
        int wordLength = word.length();

        //gets clue length
        int clueLength = clue.length();

        //checks if wordLength and clueLength are the same
        assertEquals(wordLength, clueLength);
    }

    @Test
    void test_checkIfGuessIsCorrect() {
        //set mock
        String word = "pizza";
        char guess = 'a';

        //instantiate Hangman
        Hangman hangman = new Hangman();

        //calls method to check if guess is right or wrong
        boolean correctGuess = hangman.checkGuess(word, guess);

        assertEquals(true, correctGuess);
    }

    @Test
    void test_checkIfGuessIsIncorrect() {
        //set mock
        String word = "pizza";
        char guess = 'e';

        //instantiate Hangman
        Hangman hangman = new Hangman();

        //calls method to check if guess is right or wrong
        boolean correctGuess = hangman.checkGuess(word, guess);

        assertEquals(false, correctGuess);
    }

    @Test
    void test_correctGuessResponse() {
        //set mock
        String word = "pizza";
        char guess = 'a';

        //instantiate Hangman
        Hangman hangman = new Hangman();

        String newClue = hangman.correctGuess(word, guess);

        assertEquals("____a", newClue);
    }
}