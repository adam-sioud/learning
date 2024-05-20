package wordle.game;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import wordle.util.FileHelper;

/**
 * A {@link WordProvider} that reads words from a file.
 * 
 */
public class FileWordProvider implements WordProvider {

    private final Random random;
    private final List<String> words;

    /**
     * Creates a new {@link FileWordProvider} that reads words from the default
     * file.
     * 
     * @throws IOException if the file could not be read
     */
    public FileWordProvider() throws IOException {
        this("/wordle/words.txt", true);
    }

    /**
     * Creates a new {@link FileWordProvider} that reads words from the given
     * file.
     * 
     * @param path     the path to the file
     * @param resource whether the file is a resource
     * @throws IOException if the file could not be read
     */
    public FileWordProvider(String path, boolean resource) throws IOException {
        this.words = FileHelper.readLines(path, resource);
        this.random = new Random();
    }

    /**
     * @return the words read from the file
     */
    public List<String> getWords() {
        return words;
    }

    @Override
    public String getNextWord() {
        int index = this.random.nextInt(this.words.size());
        return this.words.get(index);
    }
}
