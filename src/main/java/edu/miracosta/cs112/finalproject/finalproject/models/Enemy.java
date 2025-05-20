package edu.miracosta.cs112.finalproject.finalproject.models;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Enemy {

    /******** IMAGES *********/
    private ImageView enemyImage;

    /********** CONSTANTS **********/
    public static final int DEFAULT_HP = 10;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Punch", 1);


    /********** INSTANCE VARIABLES **********/
    protected int hp;
    protected int maxHP;
    protected Weapon weapon;

    /********** CONSTRUCTORS **********/

    public Enemy(String imagePath) {
        this(DEFAULT_HP, DEFAULT_WEAPON, imagePath);
    }

    public Enemy(int hp, Weapon weapon, String imagePath) throws IllegalArgumentException {
        if(!this.setAll(hp, weapon)) {
            throw new IllegalArgumentException ("Bad data given to full enemy constructor");
        } else {
            this.maxHP = hp;
            try {
                this.enemyImage = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
            } catch (Exception e) {
                throw new ImageLoadException("Failed to load enemy image with path: " + imagePath);
            }
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

    public int getMaxHP() {
        return this.maxHP;
    }

    public ImageView getEnemyImage() {
        return this.enemyImage;
    }

    /********** OTHER REQUIRED METHODS **********/

    public boolean equals(Enemy other) {
        return this.hp == other.hp && this.weapon.equals(other.weapon);
    }

    public boolean takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp < 0) {
            this.hp = 0;
        }
        return true;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    /********** ABSTRACT METHODS **********/


    public abstract void takeTurn(Hero hero);


}
