package main.aviaries;

import main.animals.Bird;
import java.util.List;

public class AviaryForBirds<T extends Bird> extends Aviary<T> {
    int material;
    public AviaryForBirds(int seats) {
        super(seats);
    }
}
