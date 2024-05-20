package uke12.simpleRPN;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import java.util.Stack;
import java.util.function.BinaryOperator;

public class SimpleRpn extends Application {
    
    ListView<Double> stackView = new ListView<>();
    TextField numberField = new TextField();
    Text msg = new Text();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Enkel RPN kalkulator");

        Button addButton = new Button("+");
        addButton.setOnAction(e -> performOperation((a, b) -> a + b));

        Button subtractButton = new Button("-");
        subtractButton.setOnAction(e -> performOperation((a, b) -> a - b));

        Button multiplyButton = new Button("*");
        multiplyButton.setOnAction(e -> performOperation((a, b) -> a * b));

        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> performOperation((a, b) -> a / b));

        HBox hbox1 = new HBox(2, numberField, msg);

        HBox hbox = new HBox(10, addButton, subtractButton, multiplyButton, divideButton);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10, hbox1, hbox, stackView);
        vbox.setAlignment(Pos.CENTER);

        numberField.setOnAction(e -> {
            try {
                double number = Double.parseDouble(numberField.getText());    
                stackView.getItems().addFirst(number);
                numberField.clear();
                msg.setText("");
            } catch (NumberFormatException nfe) {
                msg.setText("Skriv inn gyldig flyttall");
                numberField.clear();
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void performOperation(BinaryOperator<Double> operation) {
        //double number = Double.parseDouble(numberField.getText());
        //stack.push(number);
        if (stackView.getItems().size() >= 2) {
            double x = stackView.getItems().removeFirst();
            double y = stackView.getItems().removeFirst();
            stackView.getItems().addFirst(operation.apply(x, y));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}