package TurnstileSystem;

import java.util.Objects;

public class NumberCard extends Card {
    public int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number<0){
            throw new IllegalArgumentException();
        }
        this.number=number;
    }

    @Override
    public boolean proof() {
        if(number>0 && this.isActive())
        {
            number-=1;
            return  true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID : " +getId()+ ", Number of passes: " +number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCard that = (NumberCard) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public NumberCard(int id, int number){

        super(id);
        if(number<0){
            throw new IllegalArgumentException();
        }
        this.number =number;
    }

}
