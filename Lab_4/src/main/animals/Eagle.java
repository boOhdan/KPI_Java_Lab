package main.animals;

import main.animals.Bird;

import java.util.Objects;

public class Eagle  extends Bird {
    double wingspan;

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eagle eagle = (Eagle) o;
        return Double.compare(eagle.wingspan, wingspan) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingspan);
    }

    public Eagle(double wingspan, String feathersColor, String name, String gender, int age) {
        super(feathersColor, name, gender, age);

        this.wingspan = wingspan;
    }
    public Eagle(){}
}
