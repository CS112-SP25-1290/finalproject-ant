package edu.miracosta.cs112.finalproject.finalproject;

//WIREFRAME LINK: https://docs.google.com/presentation/d/1hXqRQOt_xRU0I0abAW18wxHUc4uWXOZ-zncE3qB0aXM/edit?usp=sharing

import javafx.application.Application; //abstract class for Java GUI
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene; //class for specific view
import javafx.scene.control.Button;
import javafx.stage.Stage; //class for window
import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    Random rng = new Random();

    public Button start;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}