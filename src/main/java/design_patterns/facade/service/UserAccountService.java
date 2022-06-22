package design_patterns.facade.service;

import design_patterns.facade.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService
{

    public boolean addAccount() {
        return true;
    }

    public boolean removeAccount(User user, long accountId) {
        user.getAccounts().removeIf(account -> account.getId() == accountId);
        return true;
    }
}
