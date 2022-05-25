package design_patterns.decorator;

public class AccountStatementProviderImpl implements AccountStatementProvider
{
    @Override
    public AccountStatement getAccountStatement(int daysOld)
    {
        return new AccountStatement();
    }
}
