package design_patterns.facade.service;

import design_patterns.facade.model.Account;
import design_patterns.facade.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService
{

    public boolean loginUser(String username) {
        return true;
    }

    public boolean logoutUser(String username)
    {
        return false;
    }

    public boolean reactivateUser(String username)
    {
        return true;
    }
}
