package main.aviaries;

import main.animals.Eagle;

import java.util.List;

public class AviaryForEagle extends AviaryForBirds<Eagle> {
    int numberOfBowls;
    public AviaryForEagle(int seats) {
        super(seats);
    }
}
