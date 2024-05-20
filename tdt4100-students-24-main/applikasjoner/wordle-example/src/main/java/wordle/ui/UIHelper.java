package wordle.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import wordle.game.LetterColor;
import wordle.game.WordleGame;

public class UIHelper {

    public static void updateGrid(GridPane grid, WordleGame game) {
        grid.getChildren().clear();

        int guessCount = game.getPreviousGuessCount();

        for (int row = 0; row < WordleGame.MAX_GUESSES; row++) {
            if (row >= guessCount) {
                for (int col = 0; col < WordleGame.WORD_LENGTH; col++) {
                    makeLetterBox(grid, row, col, null);
                }
                continue;
            }

            LetterColor[] guess = game.getGuess(row);
            for (int col = 0; col < WordleGame.WORD_LENGTH; col++) {
                makeLetterBox(grid, row, col, guess[col]);
            }
        }
    }

    private static void makeLetterBox(GridPane grid, int row, int col, LetterColor color) {
        FlowPane pane = new FlowPane();
        GridPane.setMargin(pane, new Insets(5));
        pane.setAlignment(Pos.CENTER);

        Color backgroundColor;
        if (color != null) {
            Text text = new Text(Character.toString(color.getLetter()));
            text.setFont(Font.font(44));

            pane.getChildren().add(text);

            backgroundColor = color.getUIColor();
        } else {
            backgroundColor = Color.LIGHTGRAY;
        }

        pane.setBackground(Background.fill(backgroundColor));
        grid.add(pane, col, row);
    }
}
