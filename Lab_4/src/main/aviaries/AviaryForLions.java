package main.aviaries;

import main.animals.Lion;

import java.util.List;

public class AviaryForLions extends AviaryForMammals<Lion> {
    boolean haveBox;
    public AviaryForLions(int seats) {
        super(seats);
    }
}
