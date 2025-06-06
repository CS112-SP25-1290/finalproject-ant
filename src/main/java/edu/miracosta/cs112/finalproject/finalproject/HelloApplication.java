package edu.miracosta.cs112.finalproject.finalproject;

//WIREFRAME LINK: https://docs.google.com/presentation/d/1hXqRQOt_xRU0I0abAW18wxHUc4uWXOZ-zncE3qB0aXM/edit?usp=sharing

import javafx.application.Application; //abstract class for Java GUI
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; //class for specific view
import javafx.scene.control.Button;
import javafx.stage.Stage; //class for window
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 600);
        stage.setTitle("Dungeon Crawler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*
CITATIONS

CHATGPT: Used for error checking mainly (looked at all the code just to find a typo
https://docs.oracle.com/javase/8/javafx/api/javafx/animation/PauseTransition.html
https://www.tutorialspoint.com/javafx/javafx_pause_transition.htm
Used to learn about pause transition for the FightController
 */
