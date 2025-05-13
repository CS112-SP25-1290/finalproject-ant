package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.models.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FightController {
    @FXML
    private ProgressBar playerHealthBar;
    @FXML
    private ProgressBar enemyHealthBar;
    @FXML
    private Button attackButton;

    private Hero player;
    private List<Enemy> enemies; //Is list the same as ArrayList?
    private int currentEnemyNumber = 0;
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView enemyImage;

    public void initHero(Hero player) {
        this.player = player;

        if(player instanceof Steve) {
          playerImage.setImage(new Image(getClass().getResourceAsStream("/images/steve.png")));
        } else if (player instanceof Alex) {
            playerImage.setImage(new Image(getClass().getResourceAsStream("/images/alex.png")));
        }

        //cant use initalize because at the time javafx runs, it won't know who we are playing as, so we manually start the fight here

        enemies = List.of(
                new Zombie(20, new Weapon("Fist", 2), 3),
                new Skeleton(15, new Weapon("Sword", 3), 3),
                new Slime(20, new Weapon("Fist", 1)));
        fightStart();
    }

    private void fightStart() {
        Enemy currentEnemy = enemies.get(currentEnemyNumber); //we need to update ui too. will figure that out later
        enemyImage.setImage(currentEnemy.getEnemyImage().getImage());
        updateHealthBar();
    }

    @FXML
    private void onAttackClicked() throws IOException {
        //Get the current enemy
        Enemy enemy = enemies.get(currentEnemyNumber);
        enemyImage.setImage(enemy.getEnemyImage().getImage());
        //Hero attacks!
        boolean hitLanded = player.takeTurn(enemy);

        if(!hitLanded) {
            System.out.println("Enemy dodged the attack"); //Made for the skeleton
        }

        //Check if the enemy is alive
        if(enemy.isAlive()) {
            enemy.takeTurn(player);
        }

        updateHealthBar();

        //Is the fight over?
        if(!player.isAlive()) {
            System.out.println("You died!");
        } else if(!enemy.isAlive()) {
            currentEnemyNumber++;
            if(currentEnemyNumber < enemies.size()) {
                fightStart(); //move on to the next enemy
            } else { //All the enemeies are defeated
                //move to win screen
                FXMLLoader winView = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/win-view.fxml"));
                Parent root = winView.load();
                Scene winViewScene = new Scene(root);
                Stage window = (Stage) attackButton.getScene().getWindow();
                window.setScene(winViewScene);
                window.show();
            }
        }




    }

    private void updateHealthBar() {
        Enemy currentEnemy = enemies.get(currentEnemyNumber);

        double playerHealthPercentage = (double) player.getHearts() / player.getMaxHearts();
        double enemyHealthPercentage = (double) currentEnemy.getHP() / currentEnemy.getMaxHP();

        playerHealthBar.setProgress(playerHealthPercentage);
        enemyHealthBar.setProgress(enemyHealthPercentage);
    }
}