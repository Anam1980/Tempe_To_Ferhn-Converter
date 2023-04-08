package com.example.javafxapp1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
     @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;

    public static final String C_to_F="Celsius to Fahrenheit";
    public static final String F_to_C="Fahrenheit to Celsius";
    public boolean isC_to_F=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_to_F);
        choiceBox.getItems().add(F_to_C);
        choiceBox.setValue(C_to_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if (t1.equals(C_to_F)) {
                isC_to_F=true;
            }else {
                isC_to_F=false;
            }
        });

        convertButton.setOnAction(actionEvent -> {
            convert();
        });

    }
    private void convert(){
        String Input=userInputField.getText();
        float enteredTemperature=0.0f;
        try {
            enteredTemperature = Float.parseFloat(Input);
        } catch (Exception ex){
            warnUser();
            return;
        }

        float newTemperature=0.0f;
        if (isC_to_F){
            newTemperature=(enteredTemperature * 9/5)+32;
        }else {
            newTemperature=(enteredTemperature-32)*5/9;
        }
        display(newTemperature);
    }
    private  void  warnUser(){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }
    private void  display(float newTemperature){

        String unit=isC_to_F?"F":"C";
        System.out.println("The new temperature is: "+newTemperature+unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: "+newTemperature+unit);
        alert.show();
    }
}
