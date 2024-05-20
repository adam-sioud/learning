package wordle.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LetterColorTest {
    
    @Test
    @DisplayName("Constructor makes valid instance")
    public void testConstructor() {
        LetterColor color = new LetterColor('a', LetterColor.CORRECT);

        assertEquals('a', color.getLetter(), "Wrong letter!");
        assertEquals(LetterColor.CORRECT, color.getColor(), "Wrong color!");
    }

    @Test
    @DisplayName("Invalid color throws exception")
    public void testInvalidColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LetterColor('a', 'k');
        }, "Expected exception when passing invalid color");
    }
}
