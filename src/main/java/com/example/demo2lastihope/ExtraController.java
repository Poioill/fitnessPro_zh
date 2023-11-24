package com.example.demo2lastihope;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ExtraController {

    @FXML
    TextField nameTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent e) throws IOException {

        String username = nameTextField.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = fxmlLoader.load();

        ExtraSecondController extraSecondController = fxmlLoader.getController();
        extraSecondController.displayName(username);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//
//    public void switchScene2(ActionEvent e) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
//        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
