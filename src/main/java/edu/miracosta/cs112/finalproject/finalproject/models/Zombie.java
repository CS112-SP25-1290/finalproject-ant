package edu.miracosta.cs112.finalproject.finalproject.models;

import java.util.Random;

public class Zombie extends Enemy {

    /********** CONSTANTS **********/
    public static final int DEFAULT_REGEN = 0;

    /********** INSTANCE VARIABLES **********/
    private int regen;

    /********** CONSTRUCTORS **********/

    public Zombie(int hp, Weapon weapon, int regen) {
        super(hp, weapon, "/images/ZombieVillager.png");
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

    /********** GETTERS **********/

    public int getRegen() {
        return this.regen;
    }

    /********** OTHER REQUIRED METHODS **********/

    public void doesZombieRegen() {
        this.hp += regen;
        System.out.println("regen!");

    }

    @Override
    public void takeTurn(Hero hero) {
        Random rng = new Random();
        int regenChance = rng.nextInt(10) + 1;
        if(regenChance <= 5) {
            doesZombieRegen();
        }
        hero.takeDamage(this.weapon.getDamage());

    }


}
