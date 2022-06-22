package design_patterns.facade.model;

import lombok.Data;

@Data
public class Account
{
    private long id;

    public Account(long id)
    {
        this.id = id;
    }
}
