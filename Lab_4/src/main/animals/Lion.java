package main.animals;

import java.util.Objects;

public class Lion extends Mammal {
    int speedOfImpact;

    public void setSpeedOfImpact(int speedOfImpact) {
        this.speedOfImpact = speedOfImpact;
    }

    public int getSpeedOfImpact() {
        return speedOfImpact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lion lion = (Lion) o;
        return speedOfImpact == lion.speedOfImpact;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speedOfImpact);
    }

    public Lion(String name, String gender, int age, String woolsColor, int speedOfImpact) {
        super(name, gender, age, woolsColor);

        this.speedOfImpact = speedOfImpact;
    }
    public Lion(){}

}
