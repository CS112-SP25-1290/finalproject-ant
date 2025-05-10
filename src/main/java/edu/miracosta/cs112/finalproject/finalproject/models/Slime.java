package edu.miracosta.cs112.finalproject.finalproject.models;

public class Slime extends Enemy {

    /********** CONSTANTS ***********/
    public static final int DEFAULT_HP = 10;

    public static final Weapon DEFAULT_WEAPON = new Weapon();

    @Override
    public boolean takeDamage(int hearts) {
        return false;
    }
}
