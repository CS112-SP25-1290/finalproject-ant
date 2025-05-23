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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FightController {
    @FXML
    private ProgressBar playerHealthBar;
    @FXML
    private ProgressBar enemyHealthBar;


    private Hero player;
    private List<Enemy> enemies; //Is list the same as ArrayList?
    private int currentEnemyNumber = 0;
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView enemyImage;

    @FXML
    private ImageView attackButton;
    @FXML
    private ImageView healButton;

    public void initHero(Hero player) {
        this.player = player;

        if(player instanceof Steve) {
          playerImage.setImage(new Image(getClass().getResourceAsStream("/images/Steve.png")));
        } else if (player instanceof Alex) {
            playerImage.setImage(new Image(getClass().getResourceAsStream("/images/Alex.png")));
        }

        //cant use initalize because at the time javafx runs, it won't know who we are playing as, so we manually start the fight here

        enemies = List.of(
                new Zombie(20, new Weapon("Fist", 2), 2),
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
    private void onAttackClicked(MouseEvent mouseEvent) throws IOException {
        //Get the current enemy
        Enemy enemy = enemies.get(currentEnemyNumber);
        enemyImage.setImage(enemy.getEnemyImage().getImage());

        //Hero attacks!
        boolean hitLanded = player.takeTurn(enemy);

        if(!hitLanded) {
            System.out.println("Enemy dodged the attack"); //Made for the skeleton
        }

        updateHealthBar();

        if(!enemy.isAlive()) {
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
            return; //leaves the method if the enemy is dead
        }

        attackButton.setDisable(true);
        healButton.setDisable(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> {
           enemy.takeTurn(player);
           updateHealthBar();

           if(!player.isAlive()) {
               System.out.println("You died!");
                   FXMLLoader loseView = new FXMLLoader(getClass().getResource("/edu/miracosta/cs112/finalproject/finalproject/lose-view.fxml"));
               Parent root = null;
               try {
                   root = loseView.load();
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }
               Scene winViewScene = new Scene(root);
                   Stage window = (Stage) attackButton.getScene().getWindow();
                   window.setScene(winViewScene);
                   window.show();

           }

            attackButton.setDisable(false);
            healButton.setDisable(false);
        });
        delay.play();

    }

    @FXML
    private void onHealClicked(MouseEvent mouseEvent) throws IOException {
        int healAmount = 10;
        player.heal(healAmount);
        System.out.println(player.getName() + " healed for " + healAmount + " HP!");

        updateHealthBar();

        attackButton.setDisable(true);
        healButton.setDisable(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        Enemy enemy = enemies.get(currentEnemyNumber);
        delay.setOnFinished(e -> {
            enemy.takeTurn(player);
            updateHealthBar();

            if(!player.isAlive()) {
                System.out.println("You died!");
            }

            attackButton.setDisable(false);
            healButton.setDisable(false);
        });
        delay.play();

    }


    private void updateHealthBar() {
        Enemy currentEnemy = enemies.get(currentEnemyNumber);

        double playerHealthPercentage = (double) player.getHearts() / player.getMaxHearts();
        double enemyHealthPercentage = (double) currentEnemy.getHP() / currentEnemy.getMaxHP();

        playerHealthBar.setProgress(playerHealthPercentage);
        enemyHealthBar.setProgress(enemyHealthPercentage);
    }
}