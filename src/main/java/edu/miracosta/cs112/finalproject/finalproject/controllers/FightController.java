package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.models.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import java.util.List;

public class FightController {
    @FXML
    private ProgressBar playerHealthBar;
    @FXML
    private ProgressBar enemyHealthBar;
    @FXML
    private Button attackButton;

    private Hero player;
    private List<Enemy> enemies;
    private int currentEnemyNumber = 0;

    public void initHero(Hero player) {
        this.player = player;
        //cant use initialize because at the time javafx runs, it won't know who we are playing as, so we manually start the fight here

        enemies = List.of(
                new Zombie(20, new Weapon("Fist", 2), 1),
                new Skeleton(15, new Weapon("Sword", 12), 3),
                new Slime());
        fightStart();
    }

    private void fightStart() {
        Enemy currentEnemy = enemies.get(currentEnemyNumber); //we need to update ui too. will figure that out later
        updateHealthBar();
    }

    @FXML
    private void onAttackClicked() {
        //Get the current enemy
        Enemy enemy = enemies.get(currentEnemyNumber);
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
