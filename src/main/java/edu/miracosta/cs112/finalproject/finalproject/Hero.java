package edu.miracosta.cs112.finalproject.finalproject;

public abstract class Hero {

    /************ CONSTANTS *************/
    public static final String DEFAULT_NAME = "Steve";
    public static final int DEFAULT_HEARTS = 20;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon("Fist", 1);

    /************ INSTANCE VARIABLES *************/
    private String name = null;
    private int hearts = 0;
    private Weapon weapon1 = null;

    /*********** CONSTRUCTORS *************/

    /** FULL CONSTRUCTOR
     * @SabraReed
     * @param name
     * @param hearts
     * @param weapon1
     */
    public Hero(String name, int hearts, Weapon weapon1) {
        if (!this.setAll(name, hearts, weapon1)) {
            System.out.println("ERROR: invalid data given to full GameCharacter constructor");
            System.exit(0);
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
            this.setAll(original.name, original.hearts, original.weapon1);
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
    public boolean setWeapon1(Weapon weapon) {
        if (weapon != null) {
            this.weapon1 = new Weapon(weapon);
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

        return this.setName(name) && this.setHearts(hearts) && this.setWeapon1(weapon1);
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
    public Weapon getWeapon1() {
        return new Weapon(this.weapon1);
    }


    /*********** OTHER REQUIRED METHODS *************/
//    @Override
//    public String toString() {
//        //String weapons = "Equipped" = { + this.Sword + };
//    }

    /*********** ABSTRACT METHODS *************/

    /************ HELPER METHODS *************/

}
