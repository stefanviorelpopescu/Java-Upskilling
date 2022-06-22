package design_patterns.facade.facade;

import design_patterns.facade.model.Account;
import design_patterns.facade.model.User;
import design_patterns.facade.model.UserStatus;
import design_patterns.facade.service.UserAccountService;
import design_patterns.facade.service.UserLoginService;
import org.springframework.stereotype.Component;

@Component
public class UserFacade
{
    private final UserLoginService userLoginService;
    private final UserAccountService userAccountService;

    public UserFacade(UserLoginService userLoginService, UserAccountService userAccountService)
    {
        this.userLoginService = userLoginService;
        this.userAccountService = userAccountService;
    }

    public User deactivateUser(String username)
    {
        User user = userLoginService.loginUser(username);
        for (Account account : user.getAccounts())
        {
            userAccountService.removeAccount(user, account.getId());
        }
        user.setStatus(UserStatus.DEACTIVATED);
        return user;
    }

    public boolean addUserAccount(String username, String currency) {
        userLoginService.loginUser(username);
        userAccountService.addAccount();
        return true;
    }
}
