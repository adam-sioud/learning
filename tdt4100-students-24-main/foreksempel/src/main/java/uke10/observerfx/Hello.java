package uke10.observerfx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        Button btn = new Button();
        btn.setText("Say 'Hello'");
        btn.setOnAction(event -> System.out.println("Hello"));

        // Med anonym klasse hadde dette blitt:
        // btn.setOnAction(new EventHandler<ActionEvent> () {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         System.out.println("Hello!");
        //     }
        // });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        
        primaryStage.show();
    }


}