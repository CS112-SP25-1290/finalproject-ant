package edu.miracosta.cs112.finalproject.finalproject;

//WIREFRAME LINK: https://docs.google.com/presentation/d/1hXqRQOt_xRU0I0abAW18wxHUc4uWXOZ-zncE3qB0aXM/edit?usp=sharing

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
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