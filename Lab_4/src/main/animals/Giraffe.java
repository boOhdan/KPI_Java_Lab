package main.animals;

import java.util.Objects;

public class Giraffe extends Ungulates {
    int necksLength;

    public int getNecksLength() {
        return necksLength;
    }

    public void setNecksLength(int necksLength) {
        if(necksLength<=0)
            throw new IllegalArgumentException();
        this.necksLength = necksLength;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Giraffe giraffe = (Giraffe) o;
        return necksLength == giraffe.necksLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), necksLength);
    }

    public Giraffe(String name, String gender, int age, String woolsColor, boolean domestic, int necksLength) {
        super(name, gender, age, woolsColor, domestic);
        this.necksLength = necksLength;
    }
    public Giraffe(){}
}
