package design_patterns.facade.facade;

import design_patterns.facade.model.Account;
import design_patterns.facade.model.User;
import design_patterns.facade.model.UserStatus;

public class UserMother
{

    public static User getUserWithAccounts(String username, int noOfAccounts)
    {
        User user = new User();
        user.setStatus(UserStatus.ACTIVE);
        user.setUsername(username);
        for (int i = 0; i < noOfAccounts; i++) {
            user.getAccounts().add(new Account(i));
        }
        return user;
    }

}
