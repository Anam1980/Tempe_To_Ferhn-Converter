package com.example.javafxapp1;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");//Initialize your Application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
          System.out.println("start");//Start an Application

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool ");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        //filemenu
        Menu filemenu=new Menu("File");
        MenuItem newmenuItem=new MenuItem("New");
        newmenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));


        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitmenuItem=new MenuItem("Quit");
        
        quitmenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        filemenu.getItems().addAll(newmenuItem,separatorMenuItem,quitmenuItem);


        //helpmenu
        Menu helpMenu= new Menu("Help");
        MenuItem aboutmenuItem=new MenuItem("about");
        aboutmenuItem.setOnAction(actionEvent -> addabout());

        helpMenu.getItems().addAll(aboutmenuItem);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpMenu);

      return menuBar;
    }

    private void addabout() {
        //tO DO
        Alert alertBox=new Alert(Alert.AlertType.INFORMATION);
        alertBox.setTitle("My First Desktop App");
        alertBox.setHeaderText("Learning JavaFx");
        alertBox.setContentText("I am Anam and I am just a beginner but soon I will be pro and start developing awesome Java games!!");

        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertBox.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType>clickbtn=alertBox.showAndWait();
        if (clickbtn.isPresent()&&clickbtn.get()==yesBtn){
            System.out.println("Yes Button is Clicked");
        }else {System.out.println("No Button is Clicked");
        }



    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");//Called when application is stopped and is about to shut down
        super.stop();
    }
}


