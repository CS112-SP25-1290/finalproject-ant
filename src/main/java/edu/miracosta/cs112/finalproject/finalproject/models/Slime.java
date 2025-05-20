package edu.miracosta.cs112.finalproject.finalproject.models;

public class Slime extends Enemy {

    /********** CONSTANTS ***********/
    public static final int DEFAULT_HP = 10;

    public static final Weapon DEFAULT_WEAPON = new Weapon();


    /********** CONSTRUCTORS **********/

    public Slime(int hp, Weapon weapon) {
        super(hp, weapon, "/images/SlimeBetter.png");
    }
    /*********ABSTRACT METHODS*********/

    @Override
    public void takeTurn(Hero hero) {
        hero.takeDamage(this.weapon.getDamage());
    }
}
