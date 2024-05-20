package uke10.observerfx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Label label = new Label();

        // Add a listener to the TextField's text property
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(observable);  // for å logge kallet og hva observable-objektet inneholder
                label.setText(newValue);
            }
        });

        VBox vbox = new VBox(textField, label);
        Scene scene = new Scene(vbox, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}