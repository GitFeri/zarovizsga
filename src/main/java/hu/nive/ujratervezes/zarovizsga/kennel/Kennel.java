package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        return null;
    }

    public void playWith(String name, int hours) {

    }

    public List<String> getHappyDogNames(int minHappiness) {
        return null;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
