package main.animals;

import main.animals.Animal;

import java.util.Objects;

public abstract class Bird extends Animal {
    String feathersColor;

    public String getFeathersColor() {
        return feathersColor;
    }

    public void setFeathersColor(String feathersColor) {
        this.feathersColor = feathersColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return Objects.equals(feathersColor, bird.feathersColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feathersColor);
    }

    public Bird(String feathersColor, String name, String gender, int age) {
        super(name, gender, age);

        this.feathersColor = feathersColor;
    }

    public Bird(){}
}
