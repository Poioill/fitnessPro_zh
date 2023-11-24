package com.example.demo2lastihope;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final String APP_PREFS_KEY = "appTitle";

    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene3.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 450.0, 450.0);
        stage.setTitle("Try");

        stage.setOnCloseRequest(event -> {
                    event.consume();
                    logout(stage);
                }
        );
        stage.setScene(scene);
        stage.show();
    }

    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setContentText("Are you sure you want to exit?");
        alert.setHeaderText("You are gonna leave me.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}