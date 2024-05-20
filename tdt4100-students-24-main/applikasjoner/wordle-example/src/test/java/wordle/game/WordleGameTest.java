package wordle.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wordle.util.FixedWordProvider;

public class WordleGameTest {

    private WordleGame game;

    @BeforeEach
    public void setUp() {
        // Set up a wordle game where the word is always "array"
        this.game = new WordleGame(new FixedWordProvider("array"));
    }

    @Test
    @DisplayName("Invalid guess")
    public void testInvalidGuess() {
        assertThrows(IllegalArgumentException.class, () -> this.game.makeGuess("test"), "Invalid length guess should " +
                "throw exception");
        assertThrows(IllegalArgumentException.class, () -> this.game.makeGuess(null), "null guess should throw " +
                "exception");
    }

    @Test
    @DisplayName("Too many guesses")
    public void testTooManyGuesses() {
        for (int i = 0; i < 6; i++) {
            this.game.makeGuess("wrong");
        }

        assertThrows(IllegalStateException.class, () -> this.game.makeGuess("wrong"), "Shouldn't be allowed to make 7" +
                " guesses");
    }

    @Test
    @DisplayName("Incomplete before guess")
    public void testIncompleteBeforeGuess() {
        assertFalse(this.game.isCorrect(), "Shouldn't be complete before guessing");
    }

    @Test
    @DisplayName("Complete after correct")
    public void testCompleteAfterCorrect() {
        this.game.makeGuess("array");
        assertTrue(this.game.isCorrect(), "Should be correct after guessing correctly");
    }

    @Test
    @DisplayName("Guess after correct")
    public void testGuessAfterCorrect() {
        this.game.makeGuess("array");

        assertThrows(IllegalStateException.class, () -> this.game.makeGuess("array"), "Shouldn't be able to guess " +
                "after guessing correctly");
    }

    @Test
    @DisplayName("Case insensitive")
    public void testCaseInsensitive() {
        this.game.makeGuess("ArRaY");
        assertTrue(this.game.isCorrect(), "Should be correct after guessing correctly with different casing");
    }

    private void testGuessColoring(String guess, char... colors) {
        LetterColor[] coloring = this.game.makeGuess(guess);

        assertEquals(guess.length(), coloring.length, "Wrong length for returned array");

        guess = guess.toUpperCase();

        for (int i = 0; i < coloring.length; i++) {
            LetterColor color = coloring[i];

            char expectedColor = colors[i];
            char expectedLetter = guess.charAt(i);

            assertEquals(expectedColor, color.getColor(), "Wrong color");
            assertEquals(expectedLetter, color.getLetter(), "Wrong letter");
        }
    }

    @Test
    @DisplayName("Guess coloring 1")
    public void testGuessColoring1() {
        this.testGuessColoring("barns", LetterColor.WRONG, LetterColor.INCORRECT_POSITION, LetterColor.CORRECT,
                LetterColor.WRONG, LetterColor.WRONG);
    }

    @Test
    @DisplayName("Guess coloring 2")
    public void testGuessColoring2() {
        this.testGuessColoring("aaaaa", LetterColor.CORRECT, LetterColor.WRONG, LetterColor.WRONG, LetterColor.CORRECT,
                LetterColor.WRONG);
    }

    @Test
    @DisplayName("Guess coloring 3")
    public void testGuessColoring3() {
        this.testGuessColoring("raarr", LetterColor.INCORRECT_POSITION, LetterColor.INCORRECT_POSITION,
                LetterColor.INCORRECT_POSITION, LetterColor.INCORRECT_POSITION, LetterColor.WRONG);
    }

    @Test
    @DisplayName("Guess coloring 4")
    public void testGuessColoring4() {
        this.testGuessColoring("array", LetterColor.CORRECT, LetterColor.CORRECT, LetterColor.CORRECT,
                LetterColor.CORRECT, LetterColor.CORRECT);
    }
}
