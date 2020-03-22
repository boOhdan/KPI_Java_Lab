package TurnstileSystem;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void createNumberCard() {
        Register register =new Register();


        Card expectedCard = new NumberCard(0,12);
        Card actualCard = register.createNumberCard(12);

        Assert.assertEquals(expectedCard, actualCard);

    }

    @Test
    void createNumberCard_NEGATIVE_VALUE(){
        Register register =new Register();

        Assertions.assertThrows(IllegalArgumentException.class,()->{Card card = register.createNumberCard(-3);});

    }

    @Test
    void createPreferentialPayCard() {
        Register register =new Register();


        Card expectedCard = new PreferentialPayCard(0,12);
        Card actualCard = register.createPreferentialPayCard(12);

        Assert.assertEquals(expectedCard, actualCard);
    }

    @Test
    void createPreferentialPayCard_NEGATIVE_VALUE() {
        Register register =new Register();

        Assertions.assertThrows(IllegalArgumentException.class,()->{Card card = register.createPreferentialPayCard(-3);});

    }

    @Test
    void createUsualPayCard() {
        Register register =new Register();


        Card expectedCard = new UsualPayCard(0,12);
        Card actualCard = register.createUsualPayCard(12);

        Assert.assertEquals(expectedCard, actualCard);
    }

    @Test
    void createUsualPayCard_NEGATIVE_VALUE() {
        Register register =new Register();

        Assertions.assertThrows(IllegalArgumentException.class,()->{Card card = register.createUsualPayCard(-3);});
    }

    @Test
    void createTimeCard() throws Exception{
        Register register =new Register();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date startDate =format.parse("2020/01/12");
        Date endDate =format.parse("2020/03/22");

        Card expectedCard = new TimeCard(0, startDate,endDate);
        Card actualCard = register.createTimeCard(startDate,endDate);

        Assert.assertEquals(expectedCard, actualCard);
    }

    @Test
    void createTimeCard_START_DATE_AFTER_END_DATE() throws Exception{
        Register register =new Register();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date startDate =format.parse("2020/03/22");
        Date endDate =format.parse("2020/01/12");


        Assertions.assertThrows(IllegalArgumentException.class,()->{Card card = register.createTimeCard(startDate, endDate);});

    }

    @Test
    void createTimeCard_NULL_END_DATE() throws Exception{
        Register register =new Register();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date startDate =format.parse("2020/03/22");

        Assertions.assertThrows(NullPointerException.class,()->{Card card = register.createTimeCard(startDate, null);});
    }
    @Test
    void createTimeCard_NULL_START_DATE() throws Exception{
        Register register =new Register();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date endDate =format.parse("2020/01/12");

        Assertions.assertThrows(NullPointerException.class,()->{Card card = register.createTimeCard(null, endDate);});
    }

    @Test
    void getCardInfo() {
        Register register =new Register();

        Card card = register.createUsualPayCard(12);

        String expected ="ID : 0, Funds : 12.0";
        String actual =register.getCardInfo(0);

        Assert.assertEquals(expected, actual);
    }
    @Test
    void getCardInfo_NON_EXISTENT_ID() {
        Register register =new Register();

        int nonExistentId =-9;

        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{register.getCardInfo(nonExistentId);});
    }

    @Test
    void lockCard() {
        Register register =new Register();

        Card card = register.createUsualPayCard(12);

        boolean expected =true;
        boolean actual =register.lockCard(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void lockCard_NON_EXISTENT_ID() {
        Register register =new Register();

        int nonExistentId =-9;

        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{register.lockCard(nonExistentId);});
    }

    @Test
    void unlockCard() {
        Register register =new Register();

        Card card = register.createUsualPayCard(12);
        register.lockCard(0);

        boolean expected =true;
        boolean actual =register.unlockCard(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void unlockCard_NON_EXISTENT_ID() {
        Register register =new Register();

        int nonExistentId =-9;

        Assertions.assertThrows(IndexOutOfBoundsException.class,()->{register.lockCard(nonExistentId);});
    }

    @Test
    void getPassageDate()throws Exception {
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);


        Card usualPayCard = register.createUsualPayCard(12);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date startDate =format.parse("2020/01/22");
        Date endDate =format.parse("2020/03/20");

        Card timeCard =register.createTimeCard(startDate,endDate);

        Card numberCard =register.createNumberCard(23);

        turnstile.pass(0);
        turnstile.pass(1);
        turnstile.pass(2);

        List<String> actual =register.getPassageDate();

        List<String> expected =new ArrayList<String>();
        expected.add("Result : true, Сard information  :ID : 0, Funds : 4.0");
        expected.add("Result : true, Сard information  :ID : 1, Start date : Wed Jan 22 00:00:00 EET 2020, End date : Fri Mar 20 00:00:00 EET 2020");
        expected.add("Result : true, Сard information  :ID : 2, Number of passes: 22");

        Assert.assertEquals(actual, expected);
    }

    @Test
    void testGetPassageDateById()throws Exception{
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);


        Card usualPayCard = register.createUsualPayCard(16);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Date startDate =format.parse("2020/01/22");
        Date endDate =format.parse("2020/03/20");

        Card timeCard =register.createTimeCard(startDate,endDate);

        Card numberCard =register.createNumberCard(23);

        turnstile.pass(0);
        turnstile.pass(1);
        turnstile.pass(0);
        turnstile.pass(2);
        turnstile.pass(0);

        List<String> actual =register.getPassageDate(usualPayCard.getId());

        List<String> expected =new ArrayList<String>();
        expected.add("Result : true, Сard information  :ID : 0, Funds : 8.0");
        expected.add("Result : true, Сard information  :ID : 0, Funds : 0.0");
        expected.add("Result : false, Сard information  :ID : 0, Funds : 0.0");

        Assert.assertEquals(actual, expected);
    }

    @Test
    void testGetPassageDateById_NON_EXISTENT_ID() throws Exception{
            Register register =new Register();
            Turnstile turnstile =new Turnstile();
            register.turnstiles.add(turnstile);


            Card usualPayCard = register.createUsualPayCard(16);

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

            Date startDate =format.parse("2020/01/22");
            Date endDate =format.parse("2020/03/20");

            Card timeCard =register.createTimeCard(startDate,endDate);

            Card numberCard =register.createNumberCard(23);

            turnstile.pass(0);
            turnstile.pass(1);
            turnstile.pass(0);
            turnstile.pass(2);
            turnstile.pass(0);

            int nonExistentId =9;

            List<String> actual =register.getPassageDate(nonExistentId);

            List<String> expected =new ArrayList<String>();

            Assert.assertEquals(actual, expected);
    }
    @Test
    void testGetPassageDateByType() throws Exception{
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);


        Card usualPayCard = register.createUsualPayCard(16);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Card timeCard =register.createTimeCard(format.parse("2020/01/22"), format.parse("2020/03/20"));

        Card numberCard =register.createNumberCard(23);
        Card numberCard1 =register.createNumberCard(3);
        Card numberCard2 =register.createNumberCard(11);


        turnstile.pass(4);
        turnstile.pass(1);
        turnstile.pass(0);
        turnstile.pass(2);
        turnstile.pass(0);
        turnstile.pass(2);
        turnstile.pass(1);
        turnstile.pass(4);
        turnstile.pass(3);
        turnstile.pass(3);

        List<String> actual =register.getPassageDate("NumberCard");

        List<String> expected =new ArrayList<String>();
        expected.add("Result : true, Сard information  :ID : 4, Number of passes: 10");
        expected.add("Result : true, Сard information  :ID : 2, Number of passes: 22");
        expected.add("Result : true, Сard information  :ID : 2, Number of passes: 21");
        expected.add("Result : true, Сard information  :ID : 4, Number of passes: 9");
        expected.add("Result : true, Сard information  :ID : 3, Number of passes: 2");
        expected.add("Result : true, Сard information  :ID : 3, Number of passes: 1");

        Assert.assertEquals(actual, expected);
    }
    @Test
    void testGetPassageDateByType_NULL_TYPE() throws Exception{
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);


        Card usualPayCard = register.createUsualPayCard(16);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Card timeCard =register.createTimeCard(format.parse("2020/01/22"), format.parse("2020/03/20"));

        Card numberCard =register.createNumberCard(23);
        Card numberCard1 =register.createNumberCard(3);
        Card numberCard2 =register.createNumberCard(11);


        turnstile.pass(4);
        turnstile.pass(1);
        turnstile.pass(0);
        turnstile.pass(2);


        Assertions.assertThrows(NullPointerException.class,()->{register.getPassageDate(null);});
    }
    @Test
    void testGetPassageDateByType_NON_EXISTENT_TYPE() throws Exception{
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);


        Card usualPayCard = register.createUsualPayCard(16);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Card timeCard =register.createTimeCard(format.parse("2020/01/22"), format.parse("2020/03/20"));

        Card numberCard =register.createNumberCard(23);
        Card numberCard1 =register.createNumberCard(3);
        Card numberCard2 =register.createNumberCard(11);

        turnstile.pass(4);
        turnstile.pass(1);
        turnstile.pass(0);
        turnstile.pass(2);

        String nonExistentType ="VipCard";

        Assertions.assertThrows(IllegalArgumentException.class,()->{register.getPassageDate(nonExistentType);});
    }
}