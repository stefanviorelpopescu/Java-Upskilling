package design_patterns.chain_of_responsability;

import java.util.HashMap;
import java.util.Map;

public class ATM
{
    private final Map<Denomination, Integer> money;
    private final DenominationProcessor denominationProcessor;

    public ATM(Map<Denomination, Integer> money, DenominationProcessor denominationProcessor)
    {
        this.money = money;
        this.denominationProcessor = denominationProcessor;
    }

    public Map<Denomination, Integer> withdraw(int sumOfMoney) {
        return denominationProcessor.process(sumOfMoney, new HashMap<>());
    }

}
