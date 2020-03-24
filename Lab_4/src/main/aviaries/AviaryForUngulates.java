package main.aviaries;

import main.animals.Mammal;
import main.animals.Ungulates;
import main.aviaries.AviaryForMammals;

import java.util.List;

public class AviaryForUngulates<T extends Ungulates> extends AviaryForMammals<T> {
    public AviaryForUngulates(int seats) {
        super(seats);
    }
}
