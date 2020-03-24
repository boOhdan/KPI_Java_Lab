package main.animals;

import main.animals.Mammal;

import java.util.Objects;

public abstract class Ungulates extends Mammal {
    boolean domestic;

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ungulates ungulates = (Ungulates) o;
        return domestic == ungulates.domestic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), domestic);
    }

    public Ungulates(String name, String gender, int age, String woolsColor, boolean domestic) {
        super(name, gender, age, woolsColor);
        this.domestic = domestic;
    }

    public Ungulates(){}
}
