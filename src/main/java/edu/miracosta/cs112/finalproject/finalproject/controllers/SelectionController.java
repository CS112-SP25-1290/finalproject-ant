package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.HelloApplication;
import edu.miracosta.cs112.finalproject.finalproject.models.Alex;
import edu.miracosta.cs112.finalproject.finalproject.models.Hero;
import edu.miracosta.cs112.finalproject.finalproject.models.Steve;
import edu.miracosta.cs112.finalproject.finalproject.models.Weapon;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectionController {

    @FXML
    public void onSteveClicked(MouseEvent mouseEvent) throws IOException {
        Hero selectedHero = new Steve("Steve", 500, new Weapon("Sword", 3));
        switchToFight(mouseEvent, selectedHero);
    }

    @FXML
    public void onAlexClicked(MouseEvent mouseEvent) throws IOException {
        Hero selectedHero = new Alex("Alex", 18, new Weapon("Sword", 5));
        switchToFight(mouseEvent, selectedHero);
    }

    public void switchToFight(MouseEvent mouseEvent, Hero hero) throws IOException {
        //get fight view as a scene
        FXMLLoader fightView = new FXMLLoader(HelloApplication.class.getResource("fight-view.fxml")); //we need this because load can't pass on data to next controller
        Parent root = fightView.load(); //loads file and builds ui (and what node is being used in the scene) root = layout

        //pass hero chosen to controller
        FightController controller = fightView.getController();
        controller.initHero(hero);

        //get stage (by getting object that triggered the event, cast the object on a node, checks current scene and the corresponding stage so we can update stage)
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        //creates a new scene using the root node
        Scene fightViewScene = new Scene(root);

        //set scene for stage
        window.setScene(fightViewScene);

        //show the stage
        window.show();
    }
}
