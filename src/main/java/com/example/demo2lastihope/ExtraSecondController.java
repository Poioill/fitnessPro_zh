package com.example.demo2lastihope;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ExtraSecondController implements Initializable {


    private Scene scene;
    private Parent root;
    @FXML
    private Label nameLogged, myLabelAge, myLabelCheck, labelRadio, labelDate, labelChoice, labelListView;
    @FXML
    private AnchorPane sceneSecond;
    private Stage stage;
    @FXML
    ImageView imageView;
    @FXML
    Button myButton;
    @FXML
    private TextField myTextFieldAge;
    @FXML
    private CheckBox myCheckBox;
    @FXML
    private ImageView myImageCheck;
    @FXML
    private DatePicker date;
    @FXML
    private ListView<String> myListView;
    String currentFood;
    @FXML
    private ChoiceBox<String> choiceBox;
    private final String[] food = {"Ramen", "Kim-Pab", "Fish-cake"};
    @FXML
    private RadioButton radioButton, radioButton2, radioButton3;

    Image imageCheck1 = new Image(getClass().getResourceAsStream("img_01.png"));
    Image imageCheck2 = new Image(getClass().getResourceAsStream("img_02.png"));

    int age;

    Image myImage = new Image(getClass().getResourceAsStream("img_01.png"));

    public void choseDate(ActionEvent event){
        LocalDate myDate = date.getValue();
        labelDate.setText(String.valueOf(myDate));
    }

    public void getFood(ActionEvent event){
        if (radioButton.isSelected()){
            labelRadio.setText(radioButton.getText());
        } else if (radioButton2.isSelected()) {
            labelRadio.setText(radioButton2.getText());
        } else {
            labelRadio.setText(radioButton3.getText());
        }
    }

    public void change(ActionEvent event){
        if (myCheckBox.isSelected()){
            myImageCheck.setImage(imageCheck1);
            myLabelCheck.setText("Dog 1");
        } else {
            myImageCheck.setImage(imageCheck2);
            myLabelCheck.setText("Dog 2");
        }
    }

    public void age(ActionEvent event) {
        try {
            age = Integer.parseInt(myTextFieldAge.getText());
            if (age >= 18) {
                myLabelAge.setText("Welcome, bro!");
            } else {
                myLabelAge.setText("You are not allowed to enter here, sorry :( ");
            }
        } catch (NumberFormatException e) {
            myLabelAge.setText("Enter numbers only, please!");
        } catch (Exception e) {
            myLabelAge.setText("Error");
        }
    }

    public void displayImage() {
        imageView.setImage(myImage);
    }

    public void displayName(String username) {
        nameLogged.setText("hi, " + username);
    }

    public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setContentText("Are you sure you want to exit?");
        alert.setHeaderText("You are gonna leave me.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) sceneSecond.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(food);
        choiceBox.setOnAction(this::getFoodChoice);

        myListView.getItems().addAll(food);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentFood = myListView.getSelectionModel().getSelectedItem();
                labelListView.setText(currentFood);
            }
        });
    }

    public void getFoodChoice(ActionEvent event){
        String myFood = choiceBox.getValue();
        labelChoice.setText(myFood);
    }

    public void thirdScene(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene3.fxml"));
        root = fxmlLoader.load();

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}