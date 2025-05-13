package edu.miracosta.cs112.finalproject.finalproject.models;

public abstract class Hero {

    /************ CONSTANTS *************/
    public static final String DEFAULT_NAME = "Steve";
    public static final int DEFAULT_HEARTS = 20;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon("Fist", 1);

    /************ INSTANCE VARIABLES *************/
    private String name = null;
    private int hearts = 0;
    private Weapon weapon = null;
    protected int maxHearts;

    /*********** CONSTRUCTORS *************/

    /** FULL CONSTRUCTOR
     * @SabraReed
     * @param name
     * @param hearts
     * @param weapon
     */
    public Hero(String name, int hearts, Weapon weapon) {
        if (!this.setAll(name, hearts, weapon)) {
            System.out.println("ERROR: invalid data given to full GameCharacter constructor");
            System.exit(0);
        } else {
            this.maxHearts = hearts;
        }
    }

    /** DEFAULT CONSTRUCTOR
     * @SabraReed
     */
    public Hero() {
        this(DEFAULT_NAME, DEFAULT_HEARTS, DEFAULT_WEAPON1);
    }

    public Hero(Hero original) {
        if (original == null) {
            System.out.println("ERROR: null data given to copy constructor");
            System.exit(0);
        } else {
            this.setAll(original.name, original.hearts, original.weapon);
        }
    }

    /*********** SETTERS *************/

    /** Set Name
     * @SabraReed
     * @param name
     * @return
     */
    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /** Set Hearts
     * @SabraReed
     * @param hearts
     * @return
     */
    public boolean setHearts(int hearts) {
        if (hearts >= 0) {
            this.hearts = hearts;
            return true;
        } else {
            return false;
        }
    }

    /** Set Weapon 1
     * @SabraReed
     * @param weapon
     * @return true if weapon 1 equals a new Weapon
     */
    public boolean setWeapon(Weapon weapon) {
        if (weapon != null) {
            this.weapon = new Weapon(weapon);
            return true;
        } else {
            return false;
        }
    }

    /** Set All
     * @SabraReed
     * @param name
     * @param hearts
     * @return
     */
    public boolean setAll(String name, int hearts, Weapon weapon1) {

        return this.setName(name) && this.setHearts(hearts) && this.setWeapon(weapon1);
    }

    /*********** GETTERS *************/
    /** Get Name
     * @SabraReed
     * @return Character's Name
     */
    public String getName() {
        return name;
    }

    /** Get Hearts
     * @SabraReed
     * @return Character's Hearts
     */
    public int getHearts() {
        return hearts;
    }

    /** Get Weapon 1
     * @SabraReed
     * @return Character's Weapon
     */
    public Weapon getWeapon() {
        return new Weapon(this.weapon);
    }

    public int getMaxHearts() {
        return this.maxHearts;
    }


    /*********** OTHER REQUIRED METHODS *************/
//    @Override
//    public String toString() {
//        //String weapons = "Equipped" = { + this.Sword + };
//    }

    public boolean isAlive() {
        return hearts > 0;
    }

    public void takeDamage(int damage) {
        this.hearts -= damage;
        if (this.hearts < 0) {
            this.hearts = 0;
        }
    }

    /*********** ABSTRACT METHODS *************/

    public boolean takeTurn(Enemy enemy) {
        return enemy.takeDamage(this.getWeapon().getDamage());
    }




    /************ HELPER METHODS *************/

}
