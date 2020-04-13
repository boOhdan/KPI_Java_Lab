package main.animals;

import main.animals.Animal;

import java.util.Objects;

public abstract class Mammal extends Animal {
    String woolsColor;

    public String getWoolsColor() {
        return woolsColor;
    }

    public void setWoolsColor(String woolsColor) {
        this.woolsColor = woolsColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mammal mammal = (Mammal) o;
        return Objects.equals(woolsColor, mammal.woolsColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), woolsColor);
    }

    public Mammal(String name, String gender, int age, String woolsColor) {
        super(name, gender, age);
        this.woolsColor = woolsColor;
    }
    public Mammal(){}
}
