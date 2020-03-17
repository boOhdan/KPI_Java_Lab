package TurnstileSystem;

import java.util.ArrayList;
import java.util.List;

public class Turnstile {
    List<PassageInfo> passageDate;
    static int price=8;

    public static int getPrice() {
        return price;
    }

    public static String setPrice(int newPrice) {
        if(price<0)
            throw new IllegalArgumentException();
        price = newPrice;
        return "Нова сума оплати становить : " + price;
    }
    public Turnstile() {

        passageDate = new ArrayList<PassageInfo>();
    }

    public String pass(int id){

        Card card =Register.cards.get(id);

        String result = "Result : " + card.proof() + ", Сard information  :" + card.toString();
        passageDate.add(new PassageInfo(card, result));

        return result;
    }
}
