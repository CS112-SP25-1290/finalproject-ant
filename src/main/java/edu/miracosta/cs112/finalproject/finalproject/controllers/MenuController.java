package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.HelloApplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private Label dungeonCrawlerLabel;

    @FXML
    protected void onStartButtonClicked(ActionEvent event) throws IOException {
        //get selection view as a scene
        Parent selectionView = FXMLLoader.load(HelloApplication.class.getResource("selection-view.fxml"));
        Scene selectionViewScene = new Scene(selectionView);

        //get stage
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        //set scene for stage
        window.setScene(selectionViewScene);

        //show the stage
        window.show();
    }
}