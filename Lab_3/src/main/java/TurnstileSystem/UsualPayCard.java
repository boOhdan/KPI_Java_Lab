package TurnstileSystem;

public class UsualPayCard  extends PayCard {
    @Override
    public boolean proof() {
        if (!this.isActive() || funds < Turnstile.price)
            return false;
        funds -= Turnstile.price;
        return true;
    }

    @Override
    public String toString() {
        return "ID : " +getId()+", Funds : " +funds;
    }

    public UsualPayCard(int id, double funds) {
        super(id, funds);
    }
}

