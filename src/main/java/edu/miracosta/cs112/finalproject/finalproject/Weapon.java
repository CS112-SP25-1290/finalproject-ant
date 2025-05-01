package edu.miracosta.cs112.finalproject.finalproject;

public class Weapon {
    /************ CONSTANTS *************/
    public static final String DEFAULT_NAME = "Fist";
    public static final int DEFAULT_DAMAGE = 1;

    /************ INSTANCE VARIABLES *************/
    private String name;
    private int damage;

    /*********** CONSTRUCTORS *************/

    /** FULL CONSTRUCTOR
     * @SabraReed
     * @param name
     * @param damage
     *
     */
    public Weapon(String name, int damage) {
        if(!this.setAll(name, damage)) {
            System.out.println("ERROR: invalid data given to full Weapon constructor. Shutting down");
            System.exit(0);
        }
    }
    /** DEFAULT CONSTRUCTOR
     * @SabraReed
     *
     */
    protected Weapon() {
        this(DEFAULT_NAME, DEFAULT_DAMAGE);
    }

    /** COPY CONSTRUCTOR
     * @SabraReed
     * @param original
     */
    public Weapon(Weapon original) {
        if(original == null) {
            System.out.println("ERROR: null data given to copy Weapon constructor. Shutting down.");
            System.exit(0);
        } else {
            this.setAll(original.name, original.damage);
        }
    }

    /*********** SETTERS *************/
    /** Name Setter
     *
     * @param name
     * @return true if name if not null and exceeds length, and false if not.
     */
    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /** Damage Setter
     *
     * @param damage
     * @return true if greater that 0, or false if not
     */
    public boolean setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
            return true;
        } else {
            return false;
        }
    }

    /** Set All Method
     * @SabraReed
     *
     * @param name
     * @param damage
     */
    public boolean setAll(String name, int damage) {
        return this.setName(name) && this.setDamage(damage);
    }

    /*********** GETTERS *************/
    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }


    /*********** OTHER REQUIRED METHODS *************/
}


