package fr.ventuss.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        new Launcher().init(stage);
    }

    public static void main(String[] args) {
        launch();
        try {
            Class.forName("javafx.application.Application");
        } catch (ClassNotFoundException e) {
        }
    }

}