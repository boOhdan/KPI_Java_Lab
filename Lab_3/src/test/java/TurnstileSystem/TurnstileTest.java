package TurnstileSystem;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnstileTest {

    @Test
    void pass() {
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);

        Card usualPayCard = register.createUsualPayCard(16);

        String actual =turnstile.pass(0);
        String expected ="Result : true, Сard information  :ID : 0, Funds : 8.0";

        Assert.assertEquals(actual, expected);
    }
    @Test
    void pass_NON_EXISTENT_ID() {
        Register register =new Register();
        Turnstile turnstile =new Turnstile();
        register.turnstiles.add(turnstile);

        Card usualPayCard = register.createUsualPayCard(16);

        int nonExistentId =-9;

        Assertions.assertThrows(IllegalArgumentException.class,()->{register.createUsualPayCard(nonExistentId);});

    }
}