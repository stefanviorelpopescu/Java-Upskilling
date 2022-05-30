package design_patterns.facade.chain_of_responsability;

import java.util.Map;

public class DenominationProcessor
{
    Denomination denomination;
    DenominationProcessor nextProcessor;

    public DenominationProcessor(Denomination denomination)
    {
        this.denomination = denomination;
    }

    public Map<Denomination, Integer> process(int sumOfMoney, Map<Denomination, Integer> alreadyProcessed) {

        int denominationValue = denomination.getValue();

        if (denominationValue > sumOfMoney) {
            return nextProcessor.process(sumOfMoney, alreadyProcessed);
        }
        int payableAmount = sumOfMoney / denominationValue;
        alreadyProcessed.put(denomination, payableAmount);
        sumOfMoney = sumOfMoney % denominationValue;

        if (sumOfMoney == 0) {
            return alreadyProcessed;
        }
        return nextProcessor.process(sumOfMoney, alreadyProcessed);
    }

    public DenominationProcessor setNext(DenominationProcessor denominationProcessor) {
        this.nextProcessor = denominationProcessor;
        return this.nextProcessor;
    }
}
