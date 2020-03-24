package main.aviaries;

import main.animals.Giraffe;
import main.animals.Ungulates;

import java.util.List;

public class AviaryForGiraffe extends AviaryForUngulates<Giraffe> {
    public AviaryForGiraffe(int seats) {
        super(seats);
    }
}
