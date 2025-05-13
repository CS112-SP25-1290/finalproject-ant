package edu.miracosta.cs112.finalproject.finalproject.models;

import java.util.Random;

public class Skeleton extends Enemy {
    /********** CONSTANTS **********/

    public static final int DEFAULT_DODGE_CHANCE = 0;

    /********** INSTANCE VARIABLES **********/

    private static final Random rng = new Random();
    public int dodgeChance; // 1-3 is a dodge, 4-10 is a hit

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

    public boolean rollDodgeChance() {
        int chance = rng.nextInt(10) + 1;
        return chance < this.dodgeChance;

    }

    @Override
    public void takeTurn(Hero hero) {
        hero.takeDamage(this.weapon.getDamage());
    }

    @Override
    public boolean takeDamage(int damage) {
        if(rollDodgeChance()) {
            System.out.println("Dodge");
            return false; //No damage
        } else {
            super.takeDamage(damage);
            return true; //Damage
        }
    }

}
