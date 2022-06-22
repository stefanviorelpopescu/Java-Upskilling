package design_patterns.facade.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User
{
    private UserStatus status;
    private String username;
    private List<Account> accounts = new ArrayList<>();
}
