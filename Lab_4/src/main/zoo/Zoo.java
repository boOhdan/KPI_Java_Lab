package main.zoo;

import main.animals.Animal;
import main.aviaries.Aviary;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Aviary> aviaries =new ArrayList<>();

    public int getCountOfAnimals(){
        int countOfAnimal = 0;

        for (Aviary aviary:
             aviaries) {
             countOfAnimal += aviary.getOccupiedSeats();
        }

        return countOfAnimal;
    }
    public void addAviary(Aviary<? extends Animal> aviary)
    {
        aviaries.add(aviary);
    }
}
