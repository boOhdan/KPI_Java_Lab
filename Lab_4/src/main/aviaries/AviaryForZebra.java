package main.aviaries;

import main.animals.Ungulates;
import main.animals.Zebra;

import java.util.List;

public class AviaryForZebra extends AviaryForUngulates<Zebra> {
    public int width;
    public int height;
    public AviaryForZebra(int seats) {
        super(seats);
    }
}
