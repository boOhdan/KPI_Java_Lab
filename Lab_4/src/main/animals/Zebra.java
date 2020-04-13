package main.animals;

import main.animals.Ungulates;

import java.util.Objects;

public class Zebra extends Ungulates {
    int numberOfBands;

    public int getNumberOfBands() {
        return numberOfBands;
    }

    public void setNumberOfBands(int numberOfBands) {
        this.numberOfBands = numberOfBands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Zebra zebra = (Zebra) o;
        return numberOfBands == zebra.numberOfBands;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfBands);
    }

    public Zebra(String name, String gender, int age, String woolsColor, boolean domestic, int numberOfBands) {
        super(name, gender, age, woolsColor, domestic);
        this.numberOfBands = numberOfBands;
    }

    public Zebra() {
    }
}
