package design_patterns.facade.chain_of_responsability;

public enum Denomination
{
    ten(10),
    fifty(50),
    one_hundred(100),
    two_hundred(200),
    five_hundred(500);

    Denomination(int i)
    {
        this.value = i;
    }

    private final int value;

    public int getValue()
    {
        return value;
    }
}
