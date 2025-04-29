package edu.miracosta.cs112.finalproject.finalproject;

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
        return damage;
    }

    public void attack(){

        System.out.println( " You attack with " + name + " dealing" + damage + " damage!");

    }
}
class Fist extends Weapon {
    public Fist() {
        super("edu.miracosta.cs112.finalproject.finalproject.Fist", 1);
    }
}

class Sword extends Weapon {
    public Sword() {
        super("edu.miracosta.cs112.finalproject.finalproject.Sword", 5);
    }
}

class DungeonGame {
    public static void main(String[] args) {
        Weapon fist = new Fist();
        Weapon sword = new Sword();

        fist.attack();  // "You attack with edu.miracosta.cs112.finalproject.finalproject.Fist dealing 1 damage!"
        sword.attack(); // "You attack with edu.miracosta.cs112.finalproject.finalproject.Sword dealing 5 damage!"
    }
}


