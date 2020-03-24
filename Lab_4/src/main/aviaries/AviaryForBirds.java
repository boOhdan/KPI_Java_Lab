package main.aviaries;

import main.animals.Bird;
import java.util.List;

public class AviaryForBirds<T extends Bird> extends Aviary<T> {
    public AviaryForBirds(int seats) {
        super(seats);
    }
}
