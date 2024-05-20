package wordle.game;

import java.util.Objects;

import javafx.scene.paint.Color;

/**
 * Class that contains data for a specific tile in the Wordle game
 */
public class LetterColor {
    public static final char WRONG = 'w';
    public static final char INCORRECT_POSITION = 'i';
    public static final char CORRECT = 'c';

    private final char letter;
    private final char color;

    /**
     * Creates a new instance with the given letter and color
     * 
     * @param letter The letter
     * @param color The color
     * @throws IllegalArgumentException If the color is invalid
     */
    public LetterColor(char letter, char color) {
        if (color != WRONG && color != INCORRECT_POSITION && color != CORRECT) {
            throw new IllegalArgumentException("Unknown color " + color);
        }

        this.letter = letter;
        this.color = color;
    }

    public char getLetter() {
        return letter;
    }

    public char getColor() {
        return color;
    }

    public Color getUIColor() {
        return switch (this.getColor()) {
            case WRONG -> Color.GRAY;
            case INCORRECT_POSITION -> Color.LIGHTYELLOW;
            case CORRECT -> Color.LIGHTGREEN;
            default -> throw new IllegalArgumentException("Unsupported color " + this.getColor());
        };
    }

    @Override
    public String toString() {
        return "LetterColor{" +
            "letter=" + letter +
            ", color=" + color +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LetterColor that = (LetterColor) o;
        return letter == that.letter && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, color);
    }
}
