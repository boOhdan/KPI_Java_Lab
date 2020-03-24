package main.aviaries;

import main.animals.Mammal;
import main.aviaries.Aviary;

import java.util.List;

public class AviaryForMammals<T extends Mammal> extends Aviary<T> {
    public AviaryForMammals(int seats) {
        super(seats);
    }
}
