package TurnstileSystem;

public class PreferentialPayCard extends PayCard {
    public void verification(){
        //Перевірка документів
    }

    @Override
    public boolean proof() {
        if(!this.isActive() || funds <= Turnstile.price/2)
            return false;

        verification();

        funds-=Turnstile.price/2;
        return true;
    }

    @Override
    public String toString() {
        return "ID : " +getId()+", Funds : " +funds;
    }

    public PreferentialPayCard(int id, double funds){
        super(id, funds);
    }
}
