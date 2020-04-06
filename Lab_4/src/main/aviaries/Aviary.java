package main.aviaries;

import main.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Aviary<T extends Animal> {
    int seats;

    List<T> animals =new ArrayList<>();

    public int getSeats() {
        return seats;
    }

    public int getOccupiedSeats() {
        return animals.size();
    }

    public Aviary(int seats) {
        this.seats = seats;
    }

    public boolean putAnimal(T animal) {
        if (seats == animals.size()) {
            throw new IllegalArgumentException("Недостатньо місць у вольєрі");
        }
        animals.add(animal);

        return true;
    }
    public boolean putAnimal(Collection<? extends T> animals)
    {
        if(animals.size() > seats - this.animals.size()){
            throw new IllegalArgumentException("Недостатньо місць у вольєрі");
        }

        this.animals.addAll(animals);

        return true;
    }

    public boolean removeAnimal(T animal){

        if(animals.contains(animal)) {
            animals.remove(animal);

            return true;
        }
        throw new IllegalArgumentException();
    }
}
