package edu.miracosta.cs112.finalproject.finalproject.models;

public abstract class Enemy {

    /********** CONSTANTS **********/
    public static final int DEFAULT_HP = 10;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Punch", 1);


    /********** INSTANCE VARIABLES **********/
    private int hp;
    private Weapon weapon;

    /********** CONSTRUCTORS **********/

    public Enemy() {
        this(DEFAULT_HP, DEFAULT_WEAPON);
    }

    public Enemy(int hp, Weapon weapon) {
        if(!this.setAll(hp, weapon)) {
            //System.out.println("Invalid data given to full constructor.");
            //System.exit(0);
        }
    }

    /********** SETTERS **********/

    public boolean setHP(int hp) {
        if(hp >= 0) {
            this.hp = hp;
            return true;
        } else {
            return false;
        }
    }

    public boolean setWeapon(Weapon weapon) {
        if(weapon.getName() != null && weapon.getDamage() >= 0) {
            this.weapon = weapon;
            return true;
        } else {
            return false;
        }
    }


    public boolean setAll(int hp, Weapon weapon) {
        return this.setHP(hp) && this.setWeapon(weapon);
    }


    /********** GETTERS **********/

    public int getHP() {
        return this.hp;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    /********** OTHER REQUIRED METHODS **********/

    public boolean equals(Enemy other) {
        return this.hp == other.hp && this.weapon.equals(other.weapon);
    }

    /********** ABSTRACT METHODS **********/
    public abstract boolean takeDamage(int hearts);
}
