package design_patterns.facade.model;

import lombok.Data;

import java.util.List;

@Data
public class User
{
    private List<Account> accounts;
}
