package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {
    protected int happiness;
    private String name;

    public Dog(String name) {
        this.name = name;
        happiness = 0;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void feed();

    public abstract void play(int hours);

    public String getName() {
        return name;
    }
}


