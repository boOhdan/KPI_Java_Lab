package main.aviaries;

import main.animals.Giraffe;
import main.animals.Ungulates;

import java.util.List;

public class AviaryForGiraffe extends AviaryForUngulates<Giraffe> {
    private int height;
    public AviaryForGiraffe(int seats) {
        super(seats);
    }
}
