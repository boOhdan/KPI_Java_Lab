package TurnstileSystem;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Register {
    List<Turnstile> turnstiles;
    static List<Card> cards;

    public Card createNumberCard(int number){
        NumberCard numberCard =new NumberCard(cards.size(), number);
        cards.add(numberCard);
        return numberCard;
    }
    public Card createPreferentialPayCard(int funds){
        PreferentialPayCard preferentialPayCard =new PreferentialPayCard(cards.size(),funds);
        cards.add(preferentialPayCard);
        return preferentialPayCard;
    }
    public Card createUsualPayCard(int funds){
        UsualPayCard usualPayCard =new UsualPayCard(cards.size(),funds);
        cards.add(usualPayCard);
        return usualPayCard;
    }
    public Card createTimeCard(Date start, Date end){
        TimeCard timeCard =new TimeCard(cards.size(), start, end);
        cards.add(timeCard);
        return timeCard;
    }
    public String getCardInfo(int id){
        return cards.get(id).toString();
    }
    public boolean lockCard(int id){

        cards.get(id).setActive(false);

        return !cards.get(id).isActive();
    }
    public boolean unlockCard(int id){
        cards.get(id).setActive(true);

        return cards.get(id).isActive();
    }
    public List<String> getPassageDate(String type)throws Exception
    {
        List<String> info = new ArrayList<String>();
        for (Turnstile turnstile: turnstiles
        ) {
            for (PassageInfo passageInfo:
                    turnstile.passageDate) {
                Card card = passageInfo.card;
                switch (type){
                    case "NumberCard":
                        if(card instanceof NumberCard)
                        {info.add(passageInfo.message); }
                        break;
                    case "TimeCard":
                        if(card instanceof TimeCard)
                        {info.add(passageInfo.message); }
                        break;
                    case "PreferentialPayCard":
                        if(card instanceof PreferentialPayCard)
                        {info.add(passageInfo.message); }
                        break;
                    case "UsualPayCard":
                        if(card instanceof UsualPayCard)
                        {info.add(passageInfo.message); }
                        break;
                    default:
                        throw new IllegalArgumentException("Такої типу карти неіснує");
                }
            }
        }
        return info;
    }
    public List<String> getPassageDate(int id)
    {
        List<String> info = new ArrayList<String>();
        for (Turnstile turnstile: turnstiles
        ) {
            for (PassageInfo passageInfo:
                    turnstile.passageDate) {
                if(Integer.compare(passageInfo.card.getId(), id)==0){
                    info.add(passageInfo.message);
                    System.out.println(passageInfo.message);
                }
            }
        }
        return info;
    }
    public List<String> getPassageDate()
    {
        List<String> info = new ArrayList<String>();
        for (Turnstile turnstile: turnstiles
        ) {
            for (PassageInfo passageInfo:
                    turnstile.passageDate) {
                System.out.println(passageInfo.message);
                    info.add(passageInfo.message);
            }
        }
        return info;
    }
    public Register(){
        cards= new ArrayList<Card>();
        turnstiles= new ArrayList<Turnstile>();
    }
}
