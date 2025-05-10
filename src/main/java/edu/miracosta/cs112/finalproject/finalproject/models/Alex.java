package edu.miracosta.cs112.finalproject.finalproject.models;

public  class Alex extends Hero {


    public static final String DEFAULT_NAME = "Alex";

    public static final int DEFAULT_HEARTS= 10;

    public static final Weapon DEDFUALT_WEAPON = new Weapon();

    public Alex (String name, int hearts, Weapon weapon) {
        super(name, hearts, weapon);
    }


    public Alex() {this(Alex.DEFAULT_NAME, Alex.DEFAULT_HEARTS, Alex.DEFAULT_WEAPON);}


    public Alex (Steve original) {super(original);
    }
}
