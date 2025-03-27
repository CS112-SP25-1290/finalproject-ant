public class Weapon {

    public String name;

    public int damage;

    public Weapon( String name, int damage){

        this.name=name;
        this.damage=damage;

    }

    public String getName(){
        return name;
    }

    public int getDamage(){
    reutrn damage;
    }

    public void attack(){

        System.out.println( " You attack with " + name + " dealing" + damage + " damage!");

    }
}
class Fist extends Weapon {
    public Fist() {
        super("Fist", 1);
    }
}

class Sword extends Weapon {
    public Sword() {
        super("Sword", 5);
    }
}

public class DungeonGame {
    public static void main(String[] args) {
        Weapon fist = new Fist();
        Weapon sword = new Sword();

        fist.attack();  // "You attack with Fist dealing 1 damage!"
        sword.attack(); // "You attack with Sword dealing 5 damage!"
    }
}


