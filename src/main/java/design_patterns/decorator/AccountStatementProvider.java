package design_patterns.decorator;

public interface AccountStatementProvider
{
    AccountStatement getAccountStatement(int daysOld);
}
