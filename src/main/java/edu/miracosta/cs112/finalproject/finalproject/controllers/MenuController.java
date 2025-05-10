package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuController {
    @FXML
    private Label dungeonCrawlerLabel;
    private Button startButton;

    @FXML
    protected void onStartButtonClicked() {
        dungeonCrawlerLabel.setText("Test");
    }
}