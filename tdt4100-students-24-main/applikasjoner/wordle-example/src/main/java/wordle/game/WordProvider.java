package wordle.game;

/**
 * A provider of words for the game, for example a file or a database, where
 * a random word is selected
 */
public interface WordProvider {

    /**
     * Returns the next word the user should guess
     * 
     * @return The next word the user should guess
     */
    String getNextWord();
}
