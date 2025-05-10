package edu.miracosta.cs112.finalproject.finalproject.models;

public class Steve extends Hero {

    /************** CONSTANTS ***************/
    public static final String DEFAULT_NAME = "Steve";

    public static final int DEFAULT_HEARTS = 10;

    public static final Weapon DEFAULT_WEAPON = new Weapon();

    /************** INSTANCE VARIABLES ***************/

    /************** CONSTRUCTORS ***************/
    /** Full Constructor
     * @SabraReed
     * @param name
     * @param hearts
     * @param weapon1
     */
    public Steve(String name, int hearts, Weapon weapon1) {
        super(name, hearts, weapon1);
    }

    /** Default Constructor
     * @SabraReed
     */
    public Steve() {
        this(Steve.DEFAULT_NAME, Steve.DEFAULT_HEARTS, Steve.DEFAULT_WEAPON);
    }


    /** Copy Constructor
     * @SabraReed
     * @param original
     */
    public Steve(Steve original) {
        super(original);
    }

    /************** OTHER METHODS ***************/

    @Override
    public boolean takeDamage(int hearts) {
        return false;
    }

}
