package wordle.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wordle.util.FileHelper;
import wordle.util.FixedWordProvider;

public class WorldGameFileTest {

    private WordleGame game;

    @BeforeEach
    public void setUp() {
        // Set up a wordle game where the word is always "array"
        this.game = new WordleGame(new FixedWordProvider("array"));
    }

    @Test
    @DisplayName("Write game state to file")
    public void testWriteStateToFile() throws IOException {
        this.game.makeGuess("hello");
        this.game.makeGuess("array");

        this.game.writeStateToFile("actual_state.txt");

        List<String> actualLines = FileHelper.readLines("actual_state.txt", false);
        List<String> expectedLines = FileHelper.readLines("/test_state.txt", true);

        assertEquals(expectedLines.size(), actualLines.size(), "Wrong amount of lines");

        for (int i = 0; i < actualLines.size(); i++) {
            assertEquals(expectedLines.get(i), actualLines.get(i));
        }

        Files.delete(Path.of("actual_state.txt"));
    }

    @Test
    @DisplayName("Test reading from file")
    public void testReadingFromFile() throws IOException {
        // Copy example state
        List<String> expectedLines = FileHelper.readLines("/test_state.txt", true);
        FileHelper.writeLines("test_state.txt", expectedLines);

        this.game.readStateFromFile("test_state.txt");

        assertEquals("ARRAY", this.game.getCurrentWord(), "Wrong current word");
        assertEquals(2, this.game.getPreviousGuessCount(), "Wrong amount of previous guesses");

        this.assertGuess(0, "HELLO", LetterColor.WRONG, LetterColor.WRONG, LetterColor.WRONG, LetterColor.WRONG,
                LetterColor.WRONG);
        this.assertGuess(1, "ARRAY", LetterColor.CORRECT, LetterColor.CORRECT, LetterColor.CORRECT, LetterColor.CORRECT,
                LetterColor.CORRECT);
    }

    private void assertGuess(int index, String word, char... colors) {
        LetterColor[] guess = this.game.getGuess(index);

        for (int i = 0; i < guess.length; i++) {
            LetterColor guessChar = guess[i];

            assertEquals(word.charAt(i), guessChar.getLetter(), "Wrong letter at index " + i);
            assertEquals(colors[i], guessChar.getColor(), "Wrong color at index " + i);
        }
    }
}
