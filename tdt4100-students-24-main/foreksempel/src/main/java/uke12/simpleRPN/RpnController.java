package uke12.simpleRPN;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RpnController {
    @FXML
    private TextField numberField;
    @FXML
    private ListView<Double> stackView;

    @FXML
    private Text messageText;
    
    private RpnModel model = new RpnModel();

    @FXML
    private void pushNumber() {
        try {
            double number = Double.parseDouble(numberField.getText());
            model.push(number);
            updateStackView();
            numberField.clear();
        } catch (NumberFormatException nfe) {
            messageText.setText("Skriv inn gyldig flyttall");
            numberField.clear();
        }
    }

    @FXML
    private void add() {
        model.add();
        updateStackView();
    }

    @FXML
    private void subtract() {
        model.subtract();
        updateStackView();
    }

    @FXML
    private void multiply() {
        model.multiply();
        updateStackView();
    }

    @FXML
    private void divide() {
        model.divide();
        updateStackView();
    }

    
    private void updateStackView() {
        stackView.getItems().setAll(model.getStackElements());
    }
}