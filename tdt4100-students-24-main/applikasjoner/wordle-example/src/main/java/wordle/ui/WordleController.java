package wordle.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import wordle.game.FileWordProvider;
import wordle.game.WordleGame;

public class WordleController {

    private static final String STATE_FILE_PATH = "game_state.txt";

    @FXML
    private GridPane grid;

    @FXML
    private TextField guessInputField;

    @FXML
    private Button guessButton;

    @FXML
    private Button newGameButton;

    private WordleGame game;

    @FXML
    public void initialize() {
        try {
            this.game = new WordleGame(new FileWordProvider());
        } catch (IOException e) {
            e.printStackTrace();
            this.handleCriticalError("Kunne ikke lese ordliste!");
            return;
        }

        try {
            if (Files.exists(Path.of(STATE_FILE_PATH))) {
                this.game.readStateFromFile(STATE_FILE_PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();

            Alert alert = new Alert(AlertType.WARNING, "Kunne ikke lese spillstatus");
            alert.show();
        }

        this.guessInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > WordleGame.WORD_LENGTH) {
                this.guessInputField.setText(oldValue);
                return;
            }

            this.guessButton.setDisable(newValue.length() != WordleGame.WORD_LENGTH);
        });

        this.updateGrid();
    }

    public void setGame(WordleGame game) {
        this.game = game;
        this.updateGrid();
    }

    @FXML
    public void makeNewGuess() {
        String guess = this.guessInputField.getText();
        if (guess.length() != WordleGame.WORD_LENGTH) {
            this.handleInvalidInput("Det er kun lov å skrive inn ord av lengde " + WordleGame.WORD_LENGTH);
            return;
        }

        if (!this.canGuessMore()) {
            this.handleInvalidInput("Du kan ikke gjette flere ganger!");
            return;
        }

        this.game.makeGuess(guess);
        this.updateGrid();
        this.guessInputField.setText("");

        this.saveGameState();
    }

    @FXML
    public void newGame() {
        this.game.newGame();
        this.updateGrid();

        this.saveGameState();
    }

    private void updateGrid() {
        UIHelper.updateGrid(this.grid, this.game);

        this.newGameButton.setDisable(this.game.getPreviousGuessCount() == 0);

        boolean canGuessMore = this.canGuessMore();
        this.guessInputField.setDisable(!canGuessMore);
        this.guessButton.setDisable(!canGuessMore
                || this.guessInputField.getText().length() != WordleGame.WORD_LENGTH);
    }

    private void handleInvalidInput(String message) {
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.show();
    }

    private void handleCriticalError(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.showAndWait();
        System.exit(1);
    }

    private boolean canGuessMore() {
        return !this.game.isCorrect() && this.game.getPreviousGuessCount() < WordleGame.MAX_GUESSES;
    }

    private void saveGameState() {
        try {
            this.game.writeStateToFile(STATE_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();

            Alert alert = new Alert(AlertType.WARNING, "Kunne ikke lagre spillstatus");
            alert.show();
        }
    }
}
