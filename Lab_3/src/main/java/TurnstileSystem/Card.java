package TurnstileSystem;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Card {
    private int id;
    private boolean active =true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int setId(int id) {
        if(id<0)
            throw new IllegalArgumentException("ID повино бути більше від нуля");
        return id;
    }
    public int getId() {
        return id;
    }

    public  abstract boolean proof();

    public Card(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID:" +id;
    }
}
