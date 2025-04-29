package edu.miracosta.cs112.finalproject.finalproject;

public abstract class Hero {

    /************ CONSTANTS *************/
    public static final String DEFAULT_NAME = "Steve";
    public static final int DEFAULT_HEARTS = 20;

    /************ INSTANCE VARIABLES *************/
    private String name = null;
    private int hearts = 0;

    /************ CONSTRUCTORS *************/

    /** FULL CONSTRUCTOR
     * @SabraReed
     * @param name
     * @param hearts
     */
    public Hero(String name, int hearts) {
        if (!this.setAll(name, hearts)) {
            System.out.println("ERROR: invalid data given to full GameCharacter constructor");
            System.exit(0);
        }
    }

    /** DEFAULT CONSTRUCTOR
     * @SabraReed
     */
    public Hero() {
       this(DEFAULT_NAME, DEFAULT_HEARTS);
    }

    public Hero(Hero original) {
        if (original == null) {
            System.out.println("ERROR: null data given to copy constructor");
            System.exit(0);
        } else {
            this.setAll(name, hearts);
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

    /** Set All
     * @SabraReed
     * @param name
     * @param hearts
     * @return
     */
    public boolean setAll(String name, int hearts) {
        return this.setName(name) && this.setHearts(hearts);
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

    /*********** OTHER REQUIRED METHODS *************/
    @Override
    public String toString() {

    }

    /*********** ABSTRACT METHODS *************/

    /************ HELPER METHODS *************/

}
