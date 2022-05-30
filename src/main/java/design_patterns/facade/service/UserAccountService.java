package design_patterns.facade.service;

import design_patterns.facade.model.Account;
import design_patterns.facade.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService
{

    public boolean addAccount() {
        return true;
    }

    public boolean removeAccount(String username, long accountId) {
        new User().getAccounts().remove(0);
        return true;
    }
}
