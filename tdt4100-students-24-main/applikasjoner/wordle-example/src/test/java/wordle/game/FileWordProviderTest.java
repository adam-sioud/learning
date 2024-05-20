package wordle.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordle.util.FileHelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileWordProviderTest {

    private static final List<String> WORDS = List.of("word1", "word2", "word3", "word4", "word5");

    @Test
    @DisplayName("Test reading words from the resource folder")
    public void testReadResource() throws IOException {
        FileWordProvider provider = new FileWordProvider("/test_words.txt", true);

        assertEquals(WORDS.size(), provider.getWords().size(), "The number of words should be 5");

        for (String word : WORDS) {
            assertTrue(provider.getWords().contains(word), word + " should be in the list");
        }
    }

    @Test
    @DisplayName("Test reading words from the file system")
    public void testReadFile() throws IOException {
        // Copy the words to a file in the file system
        List<String> words = FileHelper.readLines("/test_words.txt", true);
        Path testFilePath = Path.of("test_file.txt");
        Files.write(testFilePath, words, Charset.defaultCharset(), StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

        FileWordProvider provider = new FileWordProvider("test_file.txt", false);

        assertEquals(WORDS.size(), provider.getWords().size(), "The number of words should be 5");

        for (String word : WORDS) {
            assertTrue(provider.getWords().contains(word), word + " should be in the list");
        }

        Files.delete(testFilePath);
    }

    @Test
    @DisplayName("Test getting a random word")
    public void testGetNextWord() throws IOException {
        FileWordProvider provider = new FileWordProvider("/test_words.txt", true);

        for (int i = 0; i < 100; i++) {
            String word = provider.getNextWord();
            assertTrue(WORDS.contains(word), word + " should be in the list");
        }
    }
}
