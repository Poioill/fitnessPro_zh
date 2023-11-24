package com.example.demo2lastihope;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField inputField;

    public HelloController() {
    }

    @FXML
    void ShowWindow(ActionEvent event) {
        Stage newStage = new Stage();
        newStage.setTitle("Дополнительное окно");
        StackPane root = new StackPane();

        Label textLabel = new Label("Привет " + this.inputField.getText() + "!");
        root.getChildren().add(textLabel);

        Scene scene = new Scene(root, 300, 200);
        newStage.setScene(scene);
        newStage.show();

    }



    @FXML
    protected void onHelloButtonClick() {
        this.welcomeText.setText("Введи свое имя");
    }

    @FXML
    private void handleOkButton() {
        String inputText = this.inputField.getText();
        if (!inputText.isEmpty()) {
            this.welcomeText.setText("Добрый день, " + inputText + " !");
        }

    }

    @FXML
    private void handleClearButton() {
        this.welcomeText.setText("");
    }

    @FXML
    private void handleCloseButton() {
        Stage stage = (Stage) this.welcomeText.getScene().getWindow();
        stage.close();
    }

}
