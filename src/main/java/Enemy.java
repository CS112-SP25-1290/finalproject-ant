public abstract class Enemy {

    /********** CONSTANTS **********/
    public static final int DEFAULT_HP = 10;


    /********** INSTANCE VARIABLES **********/
    private int hp;

    /********** CONSTRUCTORS **********/

    public Enemy() {
        this(DEFAULT_HP);
    }

    public Enemy(int hp) {
        if(!this.setAll(hp)) {
            System.out.println("Invalid data given to full constructor.");
            System.exit(0);
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

    //While this is currently pointless since there is only one variable for enemy, setAll is created for smoother coding if more variables are added
    public boolean setAll(int hp) {
        return this.setHP(hp);
    }


    /********** GETTERS **********/

    public int getHP() {
        return this.hp;
    }

    /********** OTHER REQUIRED METHODS **********/
}
