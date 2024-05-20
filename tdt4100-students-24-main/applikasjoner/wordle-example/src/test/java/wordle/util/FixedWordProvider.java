package wordle.util;

import wordle.game.WordProvider;

public class FixedWordProvider implements WordProvider {

    private final String word;

    public FixedWordProvider(String word) {
        this.word = word;
    }

    @Override
    public String getNextWord() {
        return this.word;
    }
}
