package TurnstileSystem;

import java.util.Objects;

public abstract class PayCard extends Card{
    double funds;

    public double getFunds() {
        return funds;
    }

    public boolean replenish(double sum){
        if(sum<0)
            throw new IllegalArgumentException("Сума поповнення не може бути менша нуля");
        funds+=sum;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayCard payCard = (PayCard) o;
        return Double.compare(payCard.funds, funds) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(funds);
    }

    public PayCard(int id, double funds){
        super(id);
        if(funds<0)
            throw new IllegalArgumentException();
        this.funds =funds;
    }
}
