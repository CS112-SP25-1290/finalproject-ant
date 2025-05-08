package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Random;

public class Zombie extends Enemy {

    /********** CONSTANTS **********/
    public static final int DEFAULT_REGEN = 0;

    /********** INSTANCE VARIABLES **********/
    private int regen;

    /********** CONSTRUCTORS **********/

    public Zombie(int hp, Weapon weapon) {
        super(hp, weapon);
        this.regen = regen;
    }

    /********** SETTERS **********/

    public boolean setRegen(int regen) {
        if (regen >=0 && regen <= 1) {
            this.regen = regen;
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(int hp, Weapon weapon, int regen) {
        return super.setAll(hp, weapon) && this.setRegen(regen);
    }


}
