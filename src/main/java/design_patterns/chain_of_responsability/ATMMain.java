package design_patterns.chain_of_responsability;

import java.util.HashMap;
import java.util.Map;

import static design_patterns.chain_of_responsability.Denomination.*;

public class ATMMain
{
    public static void main(String[] args)
    {
        DenominationProcessor denominationProcessor = new DenominationProcessor(five_hundred);
        denominationProcessor.setNext(new DenominationProcessor(two_hundred))
                .setNext(new DenominationProcessor(one_hundred))
                .setNext(new DenominationProcessor(fifty))
                .setNext(new DenominationProcessor(ten));

        Map<Denomination, Integer> money = new HashMap<>();
        money.put(five_hundred, 10);
        money.put(two_hundred, 10);
        money.put(one_hundred, 10);
        money.put(fifty, 10);
        money.put(ten, 10);
        ATM atm = new ATM(money, denominationProcessor);

        System.out.println(atm.withdraw(680));
        System.out.println(atm.withdraw(900));
    }
}
