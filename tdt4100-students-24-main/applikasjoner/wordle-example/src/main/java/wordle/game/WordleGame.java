package wordle.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wordle.util.FileHelper;

/**
 * Wordle game logic
 */
public class WordleGame {

    // The maximum amount of allowed guesses
    public static final int MAX_GUESSES = 6;
    // The length the words should be
    public static final int WORD_LENGTH = 5;
    // Constant we can use as a placeholder for a letter when it is used, so
    // we know not to use it again in the calculations.
    private static final char USED_LETTER = 0;

    private final WordProvider provider;
    private String currentWord;
    private List<LetterColor[]> previousGuesses;

    /**
     * Creates a new wordle game logic controller using the given
     * {@link WordProvider word provider}.
     *
     * @param provider The {@link WordProvider provider} to get words from
     */
    public WordleGame(WordProvider provider) {
        this.provider = provider;
        this.newGame();
    }

    /**
     * @return The currently correct word
     */
    public String getCurrentWord() {
        return this.currentWord;
    }

    /**
     * Starts a new game with a new word and a new set of guesses
     */
    public void newGame() {
        this.currentWord = this.provider.getNextWord().toUpperCase();
        this.previousGuesses = new ArrayList<>();

        // Simple sanity check so that if something goes wrong here we know
        if (this.currentWord.length() != WORD_LENGTH) {
            throw new IllegalStateException(this.currentWord + " doesn't have length " + WORD_LENGTH);
        }

        System.out.println("Current word: " + this.currentWord);
    }

    /**
     * @return The amount of previously submitted guesses
     */
    public int getPreviousGuessCount() {
        return this.previousGuesses.size();
    }

    /**
     * @return If the last guess was correct
     */
    public boolean isCorrect() {
        if (this.getPreviousGuessCount() == 0) {
            return false;
        }

        int previousGuessIndex = this.getPreviousGuessCount() - 1;
        LetterColor[] previousGuess = this.getGuess(previousGuessIndex);
        return Arrays.stream(previousGuess).allMatch(guess -> guess.getColor() == LetterColor.CORRECT);
    }

    /**
     * Gets the data for the guess with the given index
     *
     * @param index The index of the guess
     * @return The data for the guess
     */
    public LetterColor[] getGuess(int index) {
        if (index < 0 || index >= this.getPreviousGuessCount()) {
            throw new IllegalArgumentException("Guess out of bounds!");
        }

        LetterColor[] guess = this.previousGuesses.get(index);
        return Arrays.copyOf(guess, guess.length);
    }

    /**
     * Makes a new guess, and adds it to the previous guesses
     *
     * @param guess The new guess word. Case-insensitive.
     * @return The coloring for the given guess
     */
    public LetterColor[] makeGuess(String guess) {
        if (guess == null || guess.length() != WORD_LENGTH) {
            throw new IllegalArgumentException("Invalid guess!");
        }

        guess = guess.toUpperCase();
        if (this.getPreviousGuessCount() >= MAX_GUESSES) {
            throw new IllegalStateException("Can't make more guesses");
        }

        if (this.isCorrect()) {
            throw new IllegalStateException("Previous guess was already correct");
        }

        char[] available = this.currentWord.toCharArray();
        LetterColor[] result = new LetterColor[WORD_LENGTH];

        // First pass: Find letters in the correct place
        for (int i = 0; i < WORD_LENGTH; i++) {
            char guessChar = guess.charAt(i);
            char wordChar = available[i];

            // Check if it is a correct guess. If so, we mark it as green
            if (guessChar == wordChar) {
                result[i] = new LetterColor(guessChar, LetterColor.CORRECT);
                // Mark this letter as used, so that we don't match another letter
                // in the guess to it later
                available[i] = USED_LETTER;
            }
        }

        // Second pass: Find letters in the wrong place, but that exist in the word
        for (int i = 0; i < WORD_LENGTH; i++) {
            // Ignore already set values from the previous pass
            if (result[i] != null) {
                continue;
            }

            char guessChar = guess.charAt(i);

            // We then check every other letter for a match
            for (int j = 0; j < WORD_LENGTH; j++) {
                char wordChar = available[j];

                // If the match exists, then this is a correct letter, but in the wrong
                // position. We match on the first found.
                if (guessChar == wordChar) {
                    result[i] = new LetterColor(guessChar, LetterColor.INCORRECT_POSITION);
                    available[j] = USED_LETTER;
                    break;
                }
            }
        }

        // Third pass: Mark the remaining letters as incorrect
        for (int i = 0; i < WORD_LENGTH; i++) {
            // Ignore already set values from the previous passes
            if (result[i] != null) {
                continue;
            }

            char guessChar = guess.charAt(i);
            result[i] = new LetterColor(guessChar, LetterColor.WRONG);
        }

        // Add this guess to the previous guesses
        this.previousGuesses.add(result);
        return Arrays.copyOf(result, result.length);
    }

    /**
     * Reads the game state from the given file
     * 
     * @param path The path to the file
     * @throws IOException If an error occurs while reading from the file
     */
    public void readStateFromFile(String path) throws IOException {
        List<String> lines = FileHelper.readLines(path, false);

        String currentWord = lines.get(0);
        List<LetterColor[]> guesses = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");

            if (parts.length != WORD_LENGTH) {
                throw new IOException("Invalid word length for word " + line);
            }

            LetterColor[] colors = new LetterColor[WORD_LENGTH];
            for (int j = 0; j < parts.length; j++) {
                String part = parts[j];

                char letter = part.charAt(0);
                char color = part.charAt(1);

                colors[j] = new LetterColor(letter, color);
            }

            guesses.add(colors);
        }

        this.currentWord = currentWord;
        this.previousGuesses = guesses;
    }

    /**
     * Saves the current state of the game to the given file
     *
     * @param path The path to save the state to
     * @throws IOException If an error occurs while writing the file
     */
    public void writeStateToFile(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(this.currentWord);

        for (LetterColor[] guess : this.previousGuesses) {
            StringBuilder builder = new StringBuilder();

            for (LetterColor letter : guess) {
                builder.append(",").append(letter.getLetter()).append(letter.getColor());
            }

            lines.add(builder.substring(1));
        }

        FileHelper.writeLines(path, lines);
    }

    /**
     * Prints the current state of the game to the console
     */
    public void printState() {
        System.out.println("Correct word: " + this.currentWord);

        for (LetterColor[] guess : this.previousGuesses) {
            StringBuilder builder = new StringBuilder();

            for (LetterColor letter : guess) {
                builder.append(" ").append(letter.getLetter()).append(letter.getColor());
            }

            System.out.println(builder.substring(1));
        }
    }

    public static void main(String[] args) {
        try {
            WordleGame game = new WordleGame(new FileWordProvider());
            game.makeGuess("hello");
            game.makeGuess("array");

            System.out.println("GAME STATE 1");
            game.printState();

            game.writeStateToFile("test_state.txt");

            game = new WordleGame(new FileWordProvider());
            game.readStateFromFile("test_state.txt");

            System.out.println("GAME STATE 2");
            game.printState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
