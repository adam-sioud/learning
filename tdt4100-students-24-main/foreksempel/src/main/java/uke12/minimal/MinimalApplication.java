
package uke12.minimal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MinimalApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {  // Start the JavaFX application
 
       Pane root = new Pane(); // Root of the scene graph
       Scene scene = new Scene(root, 500, 500);
 
       stage.setScene(scene);
       stage.setTitle("MinimalApplication");
       stage.show();
    }
 
    public static void main(String[] args) {
       launch(args);  // starter applikasjonen, som vil etter hvert kalle start over
       System.out.println("Hit kommer vi ikke før grafiske applikasjonen blir avsluttet eller alle vinduer lukket.");
    }
 }