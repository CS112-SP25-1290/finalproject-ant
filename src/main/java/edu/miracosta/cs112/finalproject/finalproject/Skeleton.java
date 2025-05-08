package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Random;

public class Skeleton extends Enemy {
    /********** CONSTANTS **********/

    public int DEFAULT_DODGE_CHANCE = 0;

    /********** INSTANCE VARIABLES **********/

    Random rng = new Random();
    public int dodgeChance;

    /********** CONSTRUCTORS **********/

    public Skeleton(int hp, Weapon weapon, int dodgeChance) {
        super(hp, weapon);
        this.dodgeChance = dodgeChance;
    }

    /********** SETTERS **********/

    public boolean setDodgeChance(int dodgeChance) {
        if(dodgeChance >= 0 && dodgeChance <= 10) {
            this.dodgeChance = dodgeChance;
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(int hp, Weapon weapon, int dodgeChance) {
        return super.setAll(hp, weapon) && this.setDodgeChance(dodgeChance);
    }

    /********** GETTERS **********/

    /********** OTHER REQUIRED METHODS **********/

    public boolean rollDodgeChance(int dodgeChance) {
        dodgeChance = rng.nextInt(10) + 1;
        if(dodgeChance <= 5) {
            return false;
        } else {
            return true;
        }

    }

}
